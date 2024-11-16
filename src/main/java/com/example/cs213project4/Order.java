package com.example.cs213project4;

/**
 * This class keeps track of the order numbers and lists of all instances in the Pizza Class.
 * @author Christopher Zhuo
 */
public class Order {
    private int number;
    private List<Pizza> pizzas;

    /**
     * Constructor for the Order Class.
     */
    public Order(int number) {
        this.number = number;
        this.pizzas = new List<>();
    }

    /**
     * Getter for the order number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Adds pizza to the order list.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        number++;
    }

    /**
     * Removes pizza from the order list.
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Calculated the price of the pizza.
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Pizza pizza : pizzas) {
            total += pizza.price();
        }
        return total;
    }

    /**
     * Returns a String representation of the order.
     * @return String representation of the order.
     */
    @Override
    public String toString() {
        return "Order #" + number + " - " + pizzas;
    }

}