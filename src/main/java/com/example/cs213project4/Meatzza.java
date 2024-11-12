package com.example.cs213project4;

/**
 * This class models a Meatzza Pizza by extending all the attributes in the Pizza class.
 * @author Christopher Zhuo
 */
public class Meatzza extends Pizza{

    /**
     Constructor for the Meatzza class.
     * @param size is the size of the pizza.
     */
    public Meatzza(Size size){
        this.setSize(size);
        getToppings().add(Topping.SAUSAGE);
        getToppings().add(Topping.PEPPERONI);
        getToppings().add(Topping.BEEF);
        getToppings().add(Topping.HAM);
    }

    /**
     * Returns the price of the pizza based on the size of it.
     */
    @Override
    public double price(){
        switch(getSize()){
            case SMALL:
                return 17.99;
            case MEDIUM:
                return 19.99;
            case LARGE:
                return 21.99;
        }
        return 0;
    }
}