package com.example.onlineshop;

import com.example.onlineshop.decorator.Atvirute;
import com.example.onlineshop.decorator.Dazymas;
import com.example.onlineshop.decorator.Pakavimas;
import com.example.onlineshop.strategy.Mokejimas;
import com.example.onlineshop.strategy.MokejimasKreditine;
import com.example.onlineshop.strategy.MokejimasPayPal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller2 {
    @FXML Button testiMyg;
    @FXML RadioButton dazymasMyg;
    @FXML RadioButton atviruteMyg;
    @FXML RadioButton pakavimasMyg;
    @FXML RadioButton kreditine;
    @FXML RadioButton paypal;
    private Produktas produktas;
    private List<Produktas> krepselis;
    private final Mokejimas mokejimas = new Mokejimas();

    public void setKrepselis(List<Produktas> cart) {
        this.krepselis = cart;
   }
    public double calculateTotal() {
        double total = 0;
        for (Produktas produktas : krepselis) {
           total += produktas.getPrice();
       }
        return total;
    }


    @FXML private void testiApmokejima(){
        apskaiciuoti();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mokejimobudas.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Online parduotuvė");
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setProduktas(Produktas produktas) {
        this.produktas = produktas;
    }
    public double apskaiciuoti() {
        double viso = calculateTotal();
        if (dazymasMyg.isSelected()) {
            produktas = new Dazymas(produktas);
            System.out.println("+ Dažymas");
            viso += 2.0;
        }
        if (atviruteMyg.isSelected()) {
            produktas = new Atvirute(produktas);
            System.out.println("+ Atvirutė");
            viso += 1.5;
        }
        if (pakavimasMyg.isSelected()) {
            produktas = new Pakavimas(produktas);
            System.out.println("+ Pakavimas");
            viso += 3.0;
        }
        System.out.println("Galutinė užsakymo kaina: " + viso);
        return viso;
    }

    @FXML private void baigti(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pabaiga.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Online parduotuvė");
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Mokejimas mokejimas = new Mokejimas();
        if (kreditine.isSelected()) {
        mokejimas.setMokejimoBudas(new MokejimasKreditine());
        } else if (paypal.isSelected()) {
        mokejimas.setMokejimoBudas(new MokejimasPayPal());
        } else {
        System.out.println("Pasirinkite mokėjimo būdą!");
            return;
        }
        //mokejimas.apdorotiUzsakyma(this);
    }
}
