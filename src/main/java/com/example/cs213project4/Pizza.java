package com.example.cs213project4;

/**
 * This is an abstract class which models a Pizza and it's attributes.
 * @author Christopher Zhuo
 */
public abstract class Pizza {
    private List<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * An abstract method that gets the price of the pizza.
     */
    public abstract double price();

    /**
     * A constructor for a pizza which initializes a list of toppings.
     */
    public Pizza(){
        toppings = new List<>();
    }

    /**
     * A setter for the crust of the pizza.
     * @param crust is the size of the pizza.
     */
    public void setCrust(Crust crust){
        this.crust = crust;
    }

    /**
     * A setter for the size of the pizza.
     * @param size is the size of the pizza.
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * A getter to return the crust of the pizza.
     */
    public Crust getCrust(){
        return this.crust;
    }

    /**
     * A getter to return the size of the pizza.
     */
    public Size getSize(){
        return size;
    }

    /**
     * A getter to return the list of topppings of the pizza. .
     */
    public List<Topping> getToppings(){
        return toppings;
    }

}