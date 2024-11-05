package com.example.cs213project4;

/**
 * this enum class defines the size of a pizza and it's correspending price
 */
public enum Size {
    /**
     * size and price
     */
    SMALL(16.99),
    /**
     * size and price
     */
    MEDIUM(18.99),
    /**
     * size and price
     */
    LARGE(20.99);
    /**
     * price of a size
     */
    private final double price;

    /**
     * Constructor for Size
     * @param price of a size
     */
    Size(double price){
        this.price = price;
    }

    /**
     * Getter for price
     * @return price of a size
     */
    public double getPrice(){
        return price;
    }
}
