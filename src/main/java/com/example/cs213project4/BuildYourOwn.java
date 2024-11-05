package com.example.cs213project4;

public class BuildYourOwn extends Pizza{
    public BuildYourOwn(Size size){
        setSize(size);
    }
    public void addTopping(Topping t){
        getToppings().add(t);
    }
    @Override
    public double price(){
        switch(getSize()){
            case SMALL:
                return 8.99 + (getToppings().size()*1.69);
            case MEDIUM:
                return 10.99 + (getToppings().size()*1.69);
            case LARGE:
                return 12.99 + (getToppings().size()*1.69);
        }
        return 0;
    }
}
