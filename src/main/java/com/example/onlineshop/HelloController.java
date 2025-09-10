package com.example.onlineshop;

import com.example.onlineshop.singleton.Inventory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML ListView<Produktas> produktaiList;
    private List<Produktas> cart = new ArrayList<>();
    @FXML Button apmoketiMyg;
    @FXML Button testiMyg;
    private Produktas produktas;
    private Inventory inventory;

    @FXML public void initialize() {
        inventory = Inventory.getInstance();
        produktaiList.setCellFactory(listView -> new ListCell<>() {
            private final Button iKrepseli = new Button("Į krepšelį");{
                iKrepseli.setOnAction(event -> {
                    Produktas produktas = getItem();
                    if (produktas != null) {
                        HelloController.this.produktas = produktas;
                        cart.add(produktas);
                        System.out.println(produktas.getName() + " įdėtas į krepšelį!");
                    }
                });
            }
            @Override
            protected void updateItem(Produktas produktas, boolean empty) {
                super.updateItem(produktas, empty);
                if (empty || produktas == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(produktas.getName() + " - " + produktas.getPrice() + " EUR");
                    setGraphic(iKrepseli);
                }
            }
        });
        produktaiList.getItems().addAll(inventory.getProducts());
    }
    public void showProducts(List<Produktas> produktai) {
        produktaiList.getItems().clear();
        produktaiList.getItems().addAll(produktai);
    }
    @FXML private void naujasLangas(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("apmokejimas.fxml"));
            Parent root = loader.load();
            Controller2 controller = loader.getController();
            controller.setProduktas(produktas);
            controller.setKrepselis(cart);
            Stage newStage = new Stage();
            newStage.setTitle("Online parduotuvė");
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}