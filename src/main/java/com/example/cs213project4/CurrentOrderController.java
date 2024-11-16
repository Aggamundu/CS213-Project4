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
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {
    @FXML
    private ListView<Pizza> orderList;
    @FXML
    private TextField orderNumber;
    @FXML
    private TextField subtotal;
    NYPizza nypizza = new NYPizza();
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
    }

    public Pizza addNYPizza(String size, String pizzaType){

        switch(pizzaType){
            case "Deluxe":
                Pizza a =  (nypizza.createDeluxe(size));
                a.setStyle("New York");
                System.out.println(a.price());
                StateManager.getInstance().subtotal+=a.price();
                StateManager.getInstance().subtotal = roundToTwoDecimals(StateManager.getInstance().subtotal);
                StateManager.getInstance().salesTax += a.price()* 0.06625;
                StateManager.getInstance().salesTax = roundToTwoDecimals(StateManager.getInstance().salesTax);
                StateManager.getInstance().orderTotal += a.price()*1.06625;
                StateManager.getInstance().orderTotal = roundToTwoDecimals(StateManager.getInstance().orderTotal);
                return a;

            case "BBQ Chicken":
                Pizza b =  (nypizza.createBBQChicken(size));
                System.out.print(b.price());
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
                System.out.print(c.price());
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

    public Pizza addNYPizzaBYO(String size, ObservableList<Topping> toppingsList){
        Pizza pizza = nypizza.createBuildYourOwn(size);
        for(Topping t: toppingsList){
            pizza.addTopping(t);
        }
        pizza.setStyle("New York");
        System.out.println(pizza.price());
        StateManager.getInstance().subtotal+= pizza.price();
        StateManager.getInstance().subtotal = Math.round((StateManager.getInstance().subtotal * 100.0))/100.0;
        StateManager.getInstance().salesTax += pizza.price()* 0.06625;
        StateManager.getInstance().salesTax = Math.round((StateManager.getInstance().salesTax * 100.0))/100.0;
        StateManager.getInstance().orderTotal += pizza.price()*1.06625;
        StateManager.getInstance().orderTotal = Math.round((StateManager.getInstance().orderTotal * 100.0))/100.0;
        return pizza;
    }
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

        }
    }
    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @FXML
    public void CurrentSwitchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
}
