package com.example.cs213project4;

public class BBQChicken extends Pizza{
    public BBQChicken(Size size){
        this.setSize(size);
        getToppings().add(Topping.BBQ_CHICKEN);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.PROVOLONE);
        getToppings().add(Topping.CHEDDAR);
    }

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
