package com.example.cs213project4;

public abstract class Pizza {
    private List<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza(){
        toppings = new List<>();
    }

    public void setCrust(Crust crust){
        this.crust = crust;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public Crust getCrust(){
        return this.crust;
    }

    public Size getSize(){
        return size;
    }
    public List<Topping> getToppings(){
        return toppings;
    }

}
