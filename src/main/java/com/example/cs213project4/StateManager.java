package com.example.cs213project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * this class manages data between fxml files and controllers
 */
public class StateManager {
    private static final StateManager instance = new StateManager();
    /**
     * all current orders
     */
    private final ObservableList<Pizza> currentOrders = FXCollections.observableArrayList();
    /**
     * all cur orders string representations
     */
    private final ObservableList<String> currentOrdersStrings = FXCollections.observableArrayList();
    /**
     * list of orders
     */
    private final ObservableList<Order> allOrders = FXCollections.observableArrayList();
    /**
     * subtotal
     */
    public double subtotal = 0;
    /**
     * sales tax
     */
    public double salesTax = 0;
    /**
     * total order cost
     */
    public double orderTotal = 0;
    /**
     * number of cur order
     */
    public int orderNumber = 1;
    /**
     * list of numbers for combo box
     */
    public final ObservableList<String> numberList = FXCollections.observableArrayList();

    /**
     * private constructor
     */
    private StateManager() {}

    /**
     * getter for instance
     * @return instance of state manager
     */
    public static StateManager getInstance() {
        return instance;
    }

    /**
     * getter for cur orders
     * @return list of pizzas
     */
    public ObservableList<Pizza> getCurrentOrders() {
        return currentOrders;
    }

    /**
     * getter for list of strings
     * @return list of order strings
     */
    public ObservableList<String> getCurrentOrdersStrings(){
        return currentOrdersStrings;
    }

    /**
     * getter for all orders
     * @return list of orders
     */
    public ObservableList<Order> getAllOrders(){
        return allOrders;
    }

    /**
     * resets state manager
     */
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
