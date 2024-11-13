package com.example.cs213project4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;
    @FXML
    private Button ChicagoStylePizza;
    @FXML
    private Button NewYorkStylePizza;
    @FXML
    private Button CheckAllOrders;
    @FXML
    private Button CheckCurrentOrder;

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    //have to create a back button
    public void switchToChicagoPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("chicago-pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToNYPizza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ny-pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheckAllOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-all-orders.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheckCurrentOrders(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("check-current-orders.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





}