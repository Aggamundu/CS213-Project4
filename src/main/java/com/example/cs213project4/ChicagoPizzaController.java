package com.example.cs213project4;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * this class controls the chicago pizza fxml file
 */
public class ChicagoPizzaController implements Initializable {
    /**
     * Pizzas to choose frmo
     */
    @FXML
    private ComboBox<String> PizzaTypes;
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

    @FXML
    private RadioButton smallButton;

    @FXML
    private ImageView imageView;
    Image defaultImg = new Image("file:src/main/resources/images/chicagopizza.jpg");
    Image deluxeImg = new Image("file:src/main/resources/images/chicagodeluxe.jpeg");
    Image bbqImg = new Image("file:src/main/resources/images/chicagobbqchicken.jpg");
    Image meatzzaImg = new Image("file:src/main/resources/images/chicagomeatzza.jpeg");
    Image byoImg = new Image("file:src/main/resources/images/chicagobuildyourown.jpg");

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final String[] pizzasArr = {"Choose your pizza","Deluxe", "BBQ Chicken", "Meatzza", "Build your own"};
    private CurrentOrderController  currentOrderController = new CurrentOrderController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        availableToppings.setDisable(true);
        smallButton.setSelected(true);
        PizzaTypes.getItems().addAll(pizzasArr);
        PizzaTypes.getSelectionModel().selectFirst();
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->disableOrderButton());
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->setCrust(newValue));
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->setPrice());
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->setPriceComboBox(newValue));
        PizzaTypes.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->addToppings());
        pizzaSize.selectedToggleProperty().addListener((observable,oldValue,newValue)->setPrice());
        pizzaSize.selectedToggleProperty().addListener((observable,oldValue,newValue)->switchSize(oldValue,newValue));
        addTopping.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> availableToppings.getSelectionModel().getSelectedItem() == null || selectedToppings.getItems().size() ==6,
                        availableToppings.getSelectionModel().selectedItemProperty(),
                        selectedToppings.getItems()
                )
        );

        removeTopping.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> selectedToppings.getSelectionModel().getSelectedItem() == null || selectedToppings.getItems().isEmpty(),
                        selectedToppings.getSelectionModel().selectedItemProperty(),
                        selectedToppings.getItems()
                )
        );

        PizzaTypes.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "Choose your pizza" -> imageView.setImage(defaultImg);
                    case "Deluxe" -> imageView.setImage(deluxeImg);
                    case "BBQ Chicken" -> imageView.setImage(bbqImg);
                    case "Meatzza" -> imageView.setImage(meatzzaImg);
                    case "Build your own" -> imageView.setImage(byoImg);
                }
            }
        });


        // Convert Enum values to ObservableList
        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());

        // Add Enum values to ListView
        availableToppings.setItems(toppings);

        ObservableList<Topping> toppings1 = FXCollections.observableArrayList();
        selectedToppings.setItems(toppings1);
        disableOrderButton();
        crust.setEditable(false);
    }


    /**
     * places an order
     */
    @FXML
    public void placeOrder() {
        ObservableList<Pizza> orders = StateManager.getInstance().getCurrentOrders();
        ObservableList<String> ordersStrings = StateManager.getInstance().getCurrentOrdersStrings();
        if (!PizzaTypes.getValue().equals("Build your own")) {
            Pizza a = currentOrderController.addChicagoPizza(getSelectedButtonText(),PizzaTypes.getValue());
            showOrderPopup(a);
            ordersStrings.add(a.toString());
            orders.add(a);
        } else {
            Pizza b = currentOrderController.addChicagoPizzaBYO(getSelectedButtonText(), selectedToppings.getItems());
            showOrderPopup(b);
            ordersStrings.add(b.toString());
            orders.add(b);
        }
    }

    private void showOrderPopup(Pizza orderedPizza) {
        // Create a new Stage (popup window)
        Stage popupStage = new Stage();
        popupStage.setTitle("Order Confirmation");

        // Create the content for the popup
        Label orderDetailsLabel = new Label("Your order details:");
        TextArea orderDetailsText = new TextArea(orderedPizza.toString());
        orderDetailsText.setEditable(false); // Make the text area read-only

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        // Layout for the popup
        VBox popupLayout = new VBox(10);
        popupLayout.setPadding(new Insets(15));
        popupLayout.setAlignment(Pos.CENTER);
        popupLayout.getChildren().addAll(orderDetailsLabel, orderDetailsText, closeButton);

        // Set the scene and show the popup
        Scene popupScene = new Scene(popupLayout, 615, 200);
        popupStage.setScene(popupScene);
        popupStage.showAndWait(); // Show the popup and wait for it to close
    }

    /**
     * disables if no pizza type is selected
     */
    private void disableOrderButton(){
        boolean fieldsFilled = PizzaTypes.getSelectionModel().getSelectedIndex()>0 &&
                getSelectedButtonText()!=null;
        orderButton.setDisable(!fieldsFilled);

    }


    private void addToppings(){
        switch(PizzaTypes.getValue()){
            case "Deluxe":
                ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.SAUSAGE,Topping.PEPPERONI,Topping.GREEN_PEPPER,Topping.ONION,Topping.MUSHROOM);
                selectedToppings.setItems(toppings);
                break;
            case "BBQ Chicken":
                ObservableList<Topping> toppings1 = FXCollections.observableArrayList(Topping.BBQ_CHICKEN,Topping.GREEN_PEPPER,Topping.PROVOLONE,Topping.CHEDDAR);
                selectedToppings.setItems(toppings1);
                break;
            case "Meatzza":
                ObservableList<Topping> toppings2 = FXCollections.observableArrayList(Topping.SAUSAGE,Topping.PEPPERONI,Topping.BEEF,Topping.HAM);
                selectedToppings.setItems(toppings2);
                break;
        }
    }

    private String getSelectedButtonText() {
        if (pizzaSize.getSelectedToggle() != null) {
            RadioButton selectedButton = (RadioButton) pizzaSize.getSelectedToggle();
            return selectedButton.getText(); // Get the text of the selected button
        }
        return null; // No button is selected
    }




    /**
     * this method adds or subtracts from the price if you switch the size of the pizza for build your own
     */
    private void switchSize(Toggle oldValue, Toggle newValue){
        if(!PizzaTypes.getValue().equals("Build your own")){
            return;
        }
        String oldButtonText =((RadioButton) oldValue).getText();
        String newButtonText = ((RadioButton) newValue).getText();
        if(oldButtonText.equals("small") && Objects.equals(newButtonText, "medium")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice + 2;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }
        if(oldButtonText.equals("small") && Objects.equals(newButtonText, "large")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice + 4;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }
        if(oldButtonText.equals("medium") && Objects.equals(newButtonText, "small")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice - 2;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }
        if(oldButtonText.equals("medium") && Objects.equals(newButtonText, "large")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice + 2;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }
        if(oldButtonText.equals("large") && Objects.equals(newButtonText, "medium")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice - 2;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }
        if(oldButtonText.equals("large") && Objects.equals(newButtonText, "small")){
            double oldPrice = Double.parseDouble(price.getText());
            double newPrice = oldPrice - 4;
            newPrice = Math.round(newPrice * 100.0) / 100.0;
            price.setText(String.valueOf(newPrice));
        }

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


        }
    }

    private void setPriceComboBox(String newValue){
        if(!newValue.equals("Build your own")){
            return;
        }
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
                price.setText("0");
        }

        // Convert Enum values to ObservableList
        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.values());

        // Add Enum values to ListView
        availableToppings.setItems(toppings);

        ObservableList<Topping> toppings1 = FXCollections.observableArrayList();
        selectedToppings.setItems(toppings1);

    }

    private void setCrust(String type){
        switch(type){
            case "Deluxe":
                crust.setText("Deep Dish");
                availableToppings.setDisable(true);
                break;
            case "BBQ Chicken":
                crust.setText("Pan");
                availableToppings.setDisable(true);
                break;
            case "Meatzza":
                crust.setText("Stuffed");
                availableToppings.setDisable(true);
                break;
            case "Build your own":
                crust.setText("Pan");
                availableToppings.setDisable(false);
                break;
            default:
                availableToppings.setDisable(true);
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

    }

    @FXML
    private void removeSelectedTopping(){
        ObservableList<Topping> chooseItems = availableToppings.getItems();
        ObservableList<Topping> selectedItems =selectedToppings.getItems();
        Topping selectedTopping = selectedToppings.getSelectionModel().getSelectedItem();

        selectedItems.remove(selectedTopping);
        chooseItems.add(selectedTopping);

        double oldPrice = Double.parseDouble(price.getText());
        double newPrice = oldPrice - 1.69;
        newPrice = Math.round(newPrice * 100.0) / 100.0;
        price.setText(String.valueOf(newPrice));
    }


    /**
     * changes scene to main
     * @param event event
     * @throws IOException exception
     */
    @FXML
    public void chicagoSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
