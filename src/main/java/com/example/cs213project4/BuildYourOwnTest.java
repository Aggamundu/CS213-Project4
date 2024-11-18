package com.example.cs213project4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for the BuildYourOwn class.
 * Tests the price() method with different numbers of toppings and sizes.
 * Ensures correctness using Black-Box Testing techniques.
 * Author: Christopher Zhuo
 */
public class BuildYourOwnTest {

    @Test
    public void testPriceSmallNoToppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        assertEquals(8.99, pizza.price(), 0.01);
    }

    @Test
    public void testPriceSmallWithThreeToppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        pizza.addTopping(Topping.SAUSAGE);
        pizza.addTopping(Topping.GREEN_PEPPER);
        pizza.addTopping(Topping.PEPPERONI);
        assertEquals(8.99 + (3 * 1.69), pizza.price(), 0.01);
    }

    @Test
    public void testPriceMediumWithFiveToppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.SAUSAGE);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.BBQ_CHICKEN);
        pizza.addTopping(Topping.BEEF);
        pizza.addTopping(Topping.PROVOLONE);
        assertEquals(10.99 + (5 * 1.69), pizza.price(), 0.01);
    }

    @Test
    public void testPriceLargeWithMaxToppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.LARGE);
        for (int i = 0; i < 7; i++) {
            pizza.addTopping(Topping.values()[i % Topping.values().length]);
        }
        assertEquals(12.99 + (7 * 1.69), pizza.price(), 0.01);
    }

    @Test
    public void testPriceLargeNoToppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.LARGE);
        assertEquals(12.99, pizza.price(), 0.01);
    }
}
