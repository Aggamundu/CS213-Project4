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

public class MainController {
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
    @FXML
    private Button switchChicagoMain;
    @FXML
    private Button switchNYMain;
    @FXML
    private Button switchAllMain;
    @FXML
    private Button switchCurrentMain;
    @FXML
    private ToggleGroup chicagoSizeToggleGroup;
    @FXML
    private RadioButton smallChicagoButton;
    @FXML
    private RadioButton mediumChicagoButton;
    @FXML
    private RadioButton largeChicagoButton;

    private final String[] pizzaTypes = {"Build Your Own", "Deluxe", "BBQ Chicken", "Meatzza"};

    //have to create a back button

    @FXML
    public void initialize() {
        // Optionally, set a default selection
        smallChicagoButton.setSelected(true);
    }

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

    /**
     * Method to switch to the Main Menu from Chicago Pizza Scene
     * @param event is an ActionEvent that changes the scene
     */
    public void chicagoSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void NYSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AllSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void CurrentSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}