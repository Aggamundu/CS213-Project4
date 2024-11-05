package com.example.cs213project4;

public class Deluxe extends Pizza {

    public Deluxe(Size size){
        this.setSize(size);
        getToppings().add(Topping.SAUSAGE);
        getToppings().add(Topping.PEPPERONI);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.ONION);
        getToppings().add(Topping.MUSHROOM);
    }

    @Override
    public double price(){
        switch(getSize()){
            case SMALL:
                return 16.99;
            case MEDIUM:
                return 18.99;
            case LARGE:
                return 20.99;
        }
        return 0;
    }
}
