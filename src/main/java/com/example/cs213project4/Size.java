package com.example.cs213project4;

public enum Size {
    SMALL(16.99),
    MEDIUM(18.99),
    LARGE(20.99);

    private final double price;

    Size(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}
