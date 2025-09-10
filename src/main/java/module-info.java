module com.example.onlineshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlineshop to javafx.fxml;
    exports com.example.onlineshop.factories;
    opens com.example.onlineshop.factories to javafx.fxml;
    exports com.example.onlineshop.products;
    opens com.example.onlineshop.products to javafx.fxml;
    exports com.example.onlineshop;
    exports com.example.onlineshop.observer;
    opens com.example.onlineshop.observer to javafx.fxml;
}