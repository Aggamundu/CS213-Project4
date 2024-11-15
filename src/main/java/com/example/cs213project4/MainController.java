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
    private RadioButton smallChicagoButton;
    @FXML
    private RadioButton mediumChicagoButton;
    @FXML
    private RadioButton largeChicagoButton;
    @FXML
    private ComboBox<String> chicagoPizzaTypeDropdown;
    @FXML
    private ListView<String> chicagoAvailableToppingsList;
    @FXML
    private ListView<String> chicagoSelectedToppingsList;
    @FXML
    private Button addChicagoTopping;
    @FXML
    private Button removeChicagoTopping;


    private static final ObservableList<String> PIZZA_TYPES = FXCollections.observableArrayList(
            "Build Your Own", "Deluxe", "BBQ Chicken", "Meatzza"
    );
    // List of available toppings
    private static final ObservableList<String> AVAILABLE_TOPPINGS = FXCollections.observableArrayList(
            "Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom",
            "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Pineapple"
    );

    //have to create a back button
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add event handlers to enforce single selection
        smallChicagoButton.setOnAction(event -> handleChicagoSizeSelection(smallChicagoButton));
        mediumChicagoButton.setOnAction(event -> handleChicagoSizeSelection(mediumChicagoButton));
        largeChicagoButton.setOnAction(event -> handleChicagoSizeSelection(largeChicagoButton));
        // Optionally, set a default selection
        smallChicagoButton.setSelected(true);
        //Populate pizza types in dropdown
        chicagoPizzaTypeDropdown.setItems(PIZZA_TYPES);
        //Set up selected toppings list
        chicagoAvailableToppingsList.setItems(FXCollections.observableArrayList(AVAILABLE_TOPPINGS));
        //Set up selected toppings list
        chicagoSelectedToppingsList.setItems(FXCollections.observableArrayList());
        //Listen for pizza type changes
        chicagoPizzaTypeDropdown.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> chicagoHandlePizzaTypeSelection(newVal));
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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void handleChicagoSizeSelection(RadioButton selectedButton) {
        // Uncheck all buttons first
        smallChicagoButton.setSelected(false);
        mediumChicagoButton.setSelected(false);
        largeChicagoButton.setSelected(false);

        // Check the selected button
        selectedButton.setSelected(true);
    }

    private void chicagoHandlePizzaTypeSelection(String pizzaType) {
        // Clear previously selected toppings
        chicagoSelectedToppingsList.getItems().clear();
        if (pizzaType.equals("Build Your Own")) {
            // Enable toppings functionality for "Build Your Own"
            chicagoAvailableToppingsList.setDisable(false);
            addChicagoTopping.setDisable(false);
            removeChicagoTopping.setDisable(false);
        } else {
            // Disable toppings functionality
            chicagoAvailableToppingsList.setDisable(true);
            addChicagoTopping.setDisable(true);
            removeChicagoTopping.setDisable(true);
            // Automatically populate toppings based on the selected pizza type
            switch (pizzaType) {
                case "Deluxe":
                    chicagoSelectedToppingsList.getItems().addAll("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
                    break;
                case "BBQ Chicken":
                    chicagoSelectedToppingsList.getItems().addAll("BBQ Chicken", "Green Pepper", "Provolone", "Cheddar");
                    break;
                case "Meatzza":
                    chicagoSelectedToppingsList.getItems().addAll("Sausage", "Pepperoni", "Beef", "Ham");
                    break;
            }
        }
    }

    @FXML
    private void chicagoAddButton() {
        String selectedTopping = chicagoAvailableToppingsList.getSelectionModel().getSelectedItem();
        if (selectedTopping != null && chicagoSelectedToppingsList.getItems().size() < 7) {
            // Add to selected toppings list
            chicagoSelectedToppingsList.getItems().add(selectedTopping);
            // Remove from available toppings list
            chicagoAvailableToppingsList.getItems().remove(selectedTopping);
        }
    }

    @FXML
    private void chicagoRemoveButton() {
        String selectedTopping = chicagoSelectedToppingsList.getSelectionModel().getSelectedItem();
        if (selectedTopping != null) {
            // Add back to available toppings list
            chicagoAvailableToppingsList.getItems().add(selectedTopping);
            // Remove from selected toppings list
            chicagoSelectedToppingsList.getItems().remove(selectedTopping);
        }
    }

}