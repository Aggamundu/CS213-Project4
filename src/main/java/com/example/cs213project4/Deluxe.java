package com.example.cs213project4;

public class Deluxe extends Pizza {

    public Deluxe(Size size){
        this.setSize(size);
        this.setCrust(Crust.DEEPDISH);
        getToppings().add(Topping.SAUSAGE);
        getToppings().add(Topping.PEPPERONI);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.ONION);
        getToppings().add(Topping.MUSHROOM);
    }

    @Override
    public double price(){
        return getSize().getPrice();
    }
}
