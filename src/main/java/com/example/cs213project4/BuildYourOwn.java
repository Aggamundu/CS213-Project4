package com.example.cs213project4;

/**
 * This class models a BuildYourOwn Pizza by extending all the attributes in the Pizza class.
 * @author Christopher Zhuo
 */
public class BuildYourOwn extends Pizza{
    /**
       Constructor for the build your own pizza class.
     */
    public BuildYourOwn(){
    }

    /**
     Method to add topping to the buildyourownpizza.
     * @param t is the topping to be added.
     */
    public void addTopping(Topping t){
        getToppings().add(t);
    }

    /**
     * Returns the price of the pizza based on the size of it.
     */
    @Override
    public double price(){
        switch(getSize()){
            case SMALL:
                return 8.99 + (getToppings().size() * 1.69);
            case MEDIUM:
                return 10.99 + (getToppings().size() * 1.69);
            case LARGE:
                return 12.99 + (getToppings().size() * 1.69);
        }
        return 0;
    }
}