package com.example.cs213project4;

public abstract class Pizza {
    private List<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza(){
        toppings = new List<>();
    }

    protected void setCrust(Crust crust){
        this.crust = crust;
    }

    protected void setSize(Size size){
        this.size = size;
    }

    protected Size getSize(){
        return size;
    }
    protected List<Topping> getToppings(){
        return toppings;
    }

}
