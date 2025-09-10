package com.example.onlineshop;

import com.example.onlineshop.factories.BuiTech;
import com.example.onlineshop.factories.ElekTech;
import com.example.onlineshop.factories.Knyga;
import com.example.onlineshop.observer.NotificationService;
import com.example.onlineshop.singleton.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public String username = "kamile";
    @Override
    public void start(Stage stage) throws IOException {
        Inventory inventory = Inventory.getInstance();
        NotificationService notificationService = new NotificationService(username);
        inventory.addObserver(notificationService);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();

        Produktas knyga1 = new Knyga().order("Little Women", 15.99);
        inventory.addProduct(knyga1);
        Produktas knyga2 = new Knyga().order("Mažasis princas", 12.99);
        inventory.addProduct(knyga2);
        Produktas knyga3 = new Knyga().order("Scarface", 10.99);
        inventory.addProduct(knyga3);

        Produktas buitech1 = new BuiTech().order("Šaldytuvas", 699.99);
        inventory.addProduct(buitech1);
        Produktas buitech2 = new BuiTech().order("Vyryklė", 499.99);
        inventory.addProduct(buitech2);
        Produktas buitech3 = new BuiTech().order("Indaplovė", 599.99);
        inventory.addProduct(buitech3);

        Produktas elekttech1 = new ElekTech().order("Telefonas", 1599.99);
        inventory.addProduct(elekttech1);
        Produktas elekttech2 = new ElekTech().order("Kompiuteris", 2599.99);
        inventory.addProduct(elekttech2);
        Produktas elekttech3 = new ElekTech().order("Fotoparatas", 999.99);
        inventory.addProduct(elekttech3);

        controller.showProducts(inventory.getProducts());

        Scene scene = new Scene(root, 374, 427);
        stage.setTitle("Online parduotuvė");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {launch();}
}