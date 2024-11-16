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


    @FXML

    /**
     * Method to switch to the Chicago Pizza scene
     * @param event is an ActionEvent that changes the scene
     */
    public void switchToChicagoPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("chicago-pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Method to switch to the NY Pizza scene
     * @param event is an ActionEvent that changes the scene
     */
    public void switchToNYPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ny-pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to switch to the Check All Orders scene
     * @param event is an ActionEvent that changes the scene
     */
    public void switchToCheckAllOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-all-orders.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to switch to the Check Current Orders scene
     * @param event is an ActionEvent that changes the scene
     */
    public void switchToCheckCurrentOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-current-orders.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}