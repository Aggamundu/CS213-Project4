package com.example.cs213project4;

/**
 * This class models a BBQChicken Pizza by extending all the attributes in the Pizza class.
 * @author Christopher Zhuo
 */
public class BBQChicken extends Pizza{

    /**
     Constructor for the BBQChicken class.
     * @param size is the size of the pizza.
     */
    public BBQChicken(Size size, Crust crust){
        this.setSize(size);
        this.setCrust(crust);
        getToppings().add(Topping.BBQ_CHICKEN);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.PROVOLONE);
        getToppings().add(Topping.CHEDDAR);
    }

    /**
     * Returns the price of the pizza based on the size of it.
     */
    @Override
    public double price(){
        switch(getSize()){
            case SMALL:
                return 14.99;
            case MEDIUM:
                return 16.99;
            case LARGE:
                return 19.99;
        }
        return 0;
    }
}