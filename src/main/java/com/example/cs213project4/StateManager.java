package com.example.cs213project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StateManager {
    private static final StateManager instance = new StateManager();

    private final ObservableList<Pizza> currentOrders = FXCollections.observableArrayList();

    // Private constructor to prevent instantiation
    private StateManager() {}

    public static StateManager getInstance() {
        return instance;
    }

    public ObservableList<Pizza> getCurrentOrders() {
        return currentOrders;
    }
}
