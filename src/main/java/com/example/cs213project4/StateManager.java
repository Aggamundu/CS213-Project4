package com.example.cs213project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class StateManager {
    private static final StateManager instance = new StateManager();

    private final ObservableList<Pizza> currentOrders = FXCollections.observableArrayList();
    private final ObservableList<String> currentOrdersStrings = FXCollections.observableArrayList();
    private final ObservableList<Order> allOrders = FXCollections.observableArrayList();
    public double subtotal = 0;
    public double salesTax = 0;
    public double orderTotal = 0;
    public int orderNumber = 1;
    public final ObservableList<String> numberList = FXCollections.observableArrayList();

    // Private constructor to prevent instantiation
    private StateManager() {}

    public static StateManager getInstance() {
        return instance;
    }

    public ObservableList<Pizza> getCurrentOrders() {
        return currentOrders;
    }
    public ObservableList<String> getCurrentOrdersStrings(){
        return currentOrdersStrings;
    }
    public ObservableList<Order> getAllOrders(){
        return allOrders;
    }
    public void resetStateManager(){
        currentOrders.clear();
        currentOrdersStrings.clear();
        allOrders.clear();
        subtotal = 0;
        salesTax = 0;
        orderTotal = 0;
        numberList.clear();
    }
}
