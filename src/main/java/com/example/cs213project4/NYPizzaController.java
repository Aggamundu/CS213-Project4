package com.example.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls the NYPizza FXML file
 */
public class NYPizzaController implements Initializable {
    /**
     * Pizzas to choose frmo
     */
    @FXML
    private ChoiceBox<String> PizzaTypes;
    /**
     * radio buttons of pizza sizes
     */
    @FXML
    private ToggleGroup pizzaSize;
    /**
     * order button
     */
    @FXML
    private Button orderButton;
    /**
     * toppings to choose from
     */
    @FXML
    private ListView<Topping> availableToppings;

    /**
     * crust type
     */
    @FXML
    private TextField crust;

    /**
     * price of pizza
     */
    @FXML
    private TextField price;
    /**
     * remove topping
     */
    @FXML
    private Button addTopping;
    /**
     * add topping
     */
    @FXML
    private Button removeTopping;

    @FXML
    private ListView<Topping> selectedToppings;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int toppingsCount;

    private final String[] pizzasArr = {"Choose your pizza","Deluxe", "BBQ Chicken", "Meatzza", "Build your own"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PizzaTypes.getItems().addAll(pizzasArr);

        PizzaTypes.getSelectionModel().selectFirst();
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->disableOrderButton());
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->setCrust(newValue));
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->setPrice());
        pizzaSize.selectedToggleProperty().addListener((observable,oldValue,newValue)->setPrice());

        // Convert Enum values to ObservableList
        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());

        // Add Enum values to ListView
        availableToppings.setItems(toppings);

        ObservableList<Topping> toppings1 = FXCollections.observableArrayList();
        selectedToppings.setItems(toppings1);
        disableOrderButton();
        crust.setEditable(false);
        availableToppings.setDisable(true);
    }

    /**
     * disables if no pizza type is selected
     */
    private void disableOrderButton(){
        boolean fieldsFilled = PizzaTypes.getSelectionModel().getSelectedIndex()>0 &&
                getSelectedButtonText()!=null;
        orderButton.setDisable(!fieldsFilled);

    }

    private String getSelectedButtonText() {
        if (pizzaSize.getSelectedToggle() != null) {
            RadioButton selectedButton = (RadioButton) pizzaSize.getSelectedToggle();
            return selectedButton.getText(); // Get the text of the selected button
        }
        return null; // No button is selected
    }


    /**
     * Switches scene to main menu
     * @param event event
     * @throws IOException exception
     */
    @FXML
    public void NYSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void setPrice(){
        String type = PizzaTypes.getValue();
        switch(type){
            case "Deluxe":
                if(getSelectedButtonText()!=null){
                    switch(getSelectedButtonText()){
                        case "small":
                            price.setText("16.99");
                            break;
                        case "medium":
                            price.setText("18.99");
                            break;
                        case "large":
                            price.setText("20.99");
                            break;
                        default:
                            break;
                    }
                }
                break;
            case "BBQ Chicken":
                if(getSelectedButtonText()!=null){
                    switch(getSelectedButtonText()){
                        case "small":
                            price.setText("14.99");
                            break;
                        case "medium":
                            price.setText("16.99");
                            break;
                        case "large":
                            price.setText("19.99");
                            break;
                        default:
                            break;
                    }
                }
                break;
            case "Meatzza":
                if(getSelectedButtonText()!=null){
                    switch(getSelectedButtonText()){
                        case "small":
                            price.setText("17.99");
                            break;
                        case "medium":
                            price.setText("19.99");
                            break;
                        case "large":
                            price.setText("21.99");
                            break;
                        default:
                            break;
                    }
                }
                break;
            case "Build your own":
                if(getSelectedButtonText()!=null){
                    switch(getSelectedButtonText()){
                        case "small":
                            price.setText("8.99");
                            break;
                        case "medium":
                            price.setText("10.99");
                            break;
                        case "large":
                            price.setText("12.99");
                            break;
                        default:
                            break;
                    }
                }
                break;
            default:
                return;
        }
    }

    private void setCrust(String type){
        switch(type){
            case "Deluxe":
                crust.setText("Brooklyn");
                availableToppings.setDisable(true);
            case "BBQ Chicken":
                crust.setText("Thin");
                availableToppings.setDisable(true);
                break;
            case "Meatzza":
                crust.setText("Hand-tossed");
                availableToppings.setDisable(true);
                break;
            case "Build your own":
                crust.setText("Hand-tossed");
                availableToppings.setDisable(false);
                break;
            default:
                break;
        }
    }

    @FXML
    private void addSelectedTopping(){
        ObservableList<Topping> chooseItems = availableToppings.getItems();
        ObservableList<Topping> selectedItems =selectedToppings.getItems();
        Topping selectedTopping = availableToppings.getSelectionModel().getSelectedItem();
        chooseItems.remove(selectedTopping);
        selectedItems.add(selectedTopping);
        double oldPrice = Double.parseDouble(price.getText());
        double newPrice = oldPrice + 1.69;
        newPrice = Math.round(newPrice * 100.0) / 100.0;
        price.setText(String.valueOf(newPrice));
        if(selectedItems.size()==7){
            addTopping.setDisable(true);
        }
    }

    @FXML
    private void removeSelectedTopping(){
        ObservableList<Topping> chooseItems = availableToppings.getItems();
        ObservableList<Topping> selectedItems =selectedToppings.getItems();
        Topping selectedTopping = selectedToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){
            return;
        }
        selectedItems.remove(selectedTopping);
        chooseItems.add(selectedTopping);

        double oldPrice = Double.parseDouble(price.getText());
        double newPrice = oldPrice - 1.69;
        newPrice = Math.round(newPrice * 100.0) / 100.0;
        price.setText(String.valueOf(newPrice));
        addTopping.setDisable(false);
    }
}
