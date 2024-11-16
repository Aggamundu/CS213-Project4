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
    NYPizza nypizza = new NYPizza();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderList.setItems(StateManager.getInstance().getCurrentOrders());
    }

    public Pizza addNYPizza(String size, String pizzaType){
        switch(pizzaType){
            case "Deluxe":
                Pizza a =  (nypizza.createDeluxe(size));
                a.setStyle("New York");
                return a;

            case "BBQ Chicken":
                Pizza b =  (nypizza.createBBQChicken(size));
                b.setStyle("New York");
                return b;

            case "Meatzza":
                Pizza c =  (nypizza.createMeatzza(size));
                c.setStyle("New York");
        }
        return null;
    }

    public Pizza addNYPizzaBYO(String size, ObservableList<Topping> toppingsList){
        Pizza pizza = nypizza.createBuildYourOwn(size);
        for(Topping t: toppingsList){
            pizza.addTopping(t);
        }
        pizza.setStyle("New York");
        return pizza;
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
