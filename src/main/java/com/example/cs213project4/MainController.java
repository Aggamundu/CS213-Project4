package com.example.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * main menu controller
 */
public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

//
//    private static final ObservableList<String> PIZZA_TYPES = FXCollections.observableArrayList(
//            "Build Your Own", "Deluxe", "BBQ Chicken", "Meatzza"
//    );
//    // List of available toppings
//    private static final ObservableList<String> AVAILABLE_TOPPINGS = FXCollections.observableArrayList(
//            "Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom",
//            "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Pineapple"
//    );

    private final String[] PIZZA_TYPES = {"Build Your Own", "Deluxe", "BBQ Chicken", "Meatzza"};
    private final String[] AVAILABLE_TOPPINGS = { "Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom",
            "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Pineapple"};

    /**
     * changes scene to chicago pizza
     * @param event event
     * @throws IOException exception
     */
    @FXML
    public void switchToChicagoPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("chicago-pizza-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Order Chicago Pizzas");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * switches scene to nypizza
     * @param event event
     * @throws IOException exception
     */
    public void switchToNYPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ny-pizza-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Order NY Pizzas");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * method to change scene to checkallorders
     * @param event event
     * @throws IOException exception
     */
    public void switchToCheckAllOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-all-orders-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("All orders");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * changes scene to current order
     * @param event event
     * @throws IOException exceptioin
     */
    public void switchToCheckCurrentOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-current-orders-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Current Order");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}