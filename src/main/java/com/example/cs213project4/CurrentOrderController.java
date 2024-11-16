package com.example.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {
    @FXML
    ListView<Pizza> orderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Pizza> list =FXCollections.observableArrayList();
    }
    Order order = new Order();

    public void addToList()
}
