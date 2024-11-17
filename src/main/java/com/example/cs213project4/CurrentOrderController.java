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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * this class controls the current order fxml file
 */
public class CurrentOrderController implements Initializable {
    @FXML
    private Button orderButton;
    @FXML
    private ListView<Pizza> orderList;
    @FXML
    private TextField orderNumber;
    @FXML
    private TextField subtotal;
    NYPizza nypizza = new NYPizza();
    ChicagoPizza chicagoPizza = new ChicagoPizza();
    @FXML
    private TextField salesTax;
    @FXML
    private TextField orderTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderList.setItems(StateManager.getInstance().getCurrentOrders());
        orderNumber.setEditable(false);
        subtotal.setEditable(false);
        orderTotal.setEditable(false);
        salesTax.setEditable(false);
        subtotal.setText(String.valueOf(StateManager.getInstance().subtotal));
        salesTax.setText(String.valueOf(StateManager.getInstance().salesTax));
        orderTotal.setText(String.valueOf(StateManager.getInstance().orderTotal));
        orderNumber.setText(String.valueOf(StateManager.getInstance().orderNumber));
        orderButton.setDisable(StateManager.getInstance().getCurrentOrders().isEmpty());
    }

    /**
     * adds ny pizza
     * @param size of pizza
     * @param pizzaType type of pizza
     * @return ny pizza
     */
    public Pizza addNYPizza(String size, String pizzaType){

        switch(pizzaType){
            case "Deluxe":
                Pizza a =  (nypizza.createDeluxe(size));
                a.setStyle("New York");
                StateManager.getInstance().subtotal+=a.price();
                StateManager.getInstance().subtotal = roundToTwoDecimals(StateManager.getInstance().subtotal);
                StateManager.getInstance().salesTax += a.price()* 0.06625;
                StateManager.getInstance().salesTax = roundToTwoDecimals(StateManager.getInstance().salesTax);
                StateManager.getInstance().orderTotal += a.price()*1.06625;
                StateManager.getInstance().orderTotal = roundToTwoDecimals(StateManager.getInstance().orderTotal);
                return a;

            case "BBQ Chicken":
                Pizza b =  (nypizza.createBBQChicken(size));
                b.setStyle("New York");
                StateManager.getInstance().subtotal+=b.price();
                StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
                StateManager.getInstance().salesTax += b.price()* 0.06625;
                StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
                StateManager.getInstance().orderTotal += b.price()*1.06625;
                StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
                return b;

            case "Meatzza":
                Pizza c =  (nypizza.createMeatzza(size));
                c.setStyle("New York");
                StateManager.getInstance().subtotal+=c.price();
                StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
                StateManager.getInstance().salesTax += c.price()* 0.06625;
                StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
                StateManager.getInstance().orderTotal += c.price()*1.06625;
                StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
                return c;
        }
        return null;
    }

    /**
     * creates chicago pizza
     * @param size of pizza
     * @param pizzaType pizza type
     * @return chicago pizza
     */
    public Pizza addChicagoPizza(String size, String pizzaType){

        switch(pizzaType){
            case "Deluxe":
                Pizza a =  (chicagoPizza.createDeluxe(size));
                a.setStyle("Chicago");
                StateManager.getInstance().subtotal+=a.price();
                StateManager.getInstance().subtotal = roundToTwoDecimals(StateManager.getInstance().subtotal);
                StateManager.getInstance().salesTax += a.price()* 0.06625;
                StateManager.getInstance().salesTax = roundToTwoDecimals(StateManager.getInstance().salesTax);
                StateManager.getInstance().orderTotal += a.price()*1.06625;
                StateManager.getInstance().orderTotal = roundToTwoDecimals(StateManager.getInstance().orderTotal);
                return a;

            case "BBQ Chicken":
                Pizza b =  (chicagoPizza.createBBQChicken(size));
                b.setStyle("Chicago");
                StateManager.getInstance().subtotal+=b.price();
                StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
                StateManager.getInstance().salesTax += b.price()* 0.06625;
                StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
                StateManager.getInstance().orderTotal += b.price()*1.06625;
                StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
                return b;

            case "Meatzza":
                Pizza c =  (chicagoPizza.createMeatzza(size));
                c.setStyle("Chicago");
                StateManager.getInstance().subtotal+=c.price();
                StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
                StateManager.getInstance().salesTax += c.price()* 0.06625;
                StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
                StateManager.getInstance().orderTotal += c.price()*1.06625;
                StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
                return c;
        }
        return null;
    }

    /**
     * creates ny byo pizza
     * @param size of pizza
     * @param toppingsList toppings
     * @return byo pizza
     */
    public Pizza addNYPizzaBYO(String size, ObservableList<Topping> toppingsList){
        Pizza pizza = nypizza.createBuildYourOwn(size);
        for(Topping t: toppingsList){
            pizza.addTopping(t);
        }
        pizza.setStyle("New York");
        StateManager.getInstance().subtotal+= pizza.price();
        StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
        StateManager.getInstance().salesTax += pizza.price()* 0.06625;
        StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
        StateManager.getInstance().orderTotal += pizza.price()*1.06625;
        StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
        return pizza;
    }

    /**
     * creates a chicago pizza byo
     * @param size of pizza
     * @param toppingsList list of toppings
     * @return chicago pizza byo
     */
    public Pizza addChicagoPizzaBYO(String size, ObservableList<Topping> toppingsList){
        Pizza pizza = chicagoPizza.createBuildYourOwn(size);
        for(Topping t: toppingsList){
            pizza.addTopping(t);
        }
        pizza.setStyle("Chicago");
        StateManager.getInstance().subtotal+= pizza.price();
        StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
        StateManager.getInstance().salesTax += pizza.price()* 0.06625;
        StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
        StateManager.getInstance().orderTotal += pizza.price()*1.06625;
        StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
        return pizza;
    }

    /**
     * this clears the current order
     */
    @FXML
    public void clearButton(){
        StateManager.getInstance().getCurrentOrders().clear();
        StateManager.getInstance().getCurrentOrdersStrings().clear();
        StateManager.getInstance().subtotal = 0.0;
        StateManager.getInstance().salesTax = 0.0;
        StateManager.getInstance().orderTotal = 0.0;
        subtotal.setText("0");
        salesTax.setText("0");
        orderTotal.setText("0");
    }

    /**
     * removes pizza from lists
     */
    @FXML
    public void removePizza(){
        int selectedIndex = orderList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) { // Ensure an item is selected
            StateManager.getInstance().subtotal -= StateManager.getInstance().getCurrentOrders().get(selectedIndex).price();
            StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
            StateManager.getInstance().salesTax -= StateManager.getInstance().getCurrentOrders().get(selectedIndex).price()*0.06625;
            StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
            StateManager.getInstance().orderTotal -= StateManager.getInstance().getCurrentOrders().get(selectedIndex).price() + StateManager.getInstance().getCurrentOrders().get(selectedIndex).price()*0.06625;
            StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
            StateManager.getInstance().getCurrentOrders().remove(selectedIndex); // Remove item at the selected index
            StateManager.getInstance().getCurrentOrdersStrings().remove(selectedIndex); // Remove item at the selected index
            subtotal.setText(String.valueOf(StateManager.getInstance().subtotal));
            salesTax.setText(String.valueOf(StateManager.getInstance().salesTax));
            orderTotal.setText(String.valueOf(StateManager.getInstance().orderTotal));
            orderButton.setDisable(StateManager.getInstance().getCurrentOrders().isEmpty());

        }
    }
    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * places order
     */
    @FXML
    private void placeOrder(){
        Order o = new Order(Integer.parseInt(orderNumber.getText()),StateManager.getInstance().orderTotal,StateManager.getInstance().getCurrentOrders(),StateManager.getInstance().getCurrentOrdersStrings());
        StateManager.getInstance().getAllOrders().add(o);
        StateManager.getInstance().numberList.add(orderNumber.getText());

        StateManager.getInstance().orderNumber++;
        orderNumber.setText(String.valueOf(StateManager.getInstance().orderNumber));

        StateManager.getInstance().getCurrentOrders().clear();
        StateManager.getInstance().getCurrentOrdersStrings().clear();
        StateManager.getInstance().subtotal = 0.0;
        StateManager.getInstance().salesTax = 0.0;
        StateManager.getInstance().orderTotal = 0.0;
        subtotal.setText("0");
        salesTax.setText("0");
        orderTotal.setText("0");
    }

    /**
     * switches scene to main menu
     * @param event event
     * @throws IOException exception
     */
    @FXML
    public void CurrentSwitchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-menu-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
    Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
}
