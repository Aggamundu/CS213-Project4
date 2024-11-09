package com.example.cs213project4;

public class ChicagoPizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe(Size.SMALL);
        pizza.setCrust(Crust.DEEPDISH);
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Deluxe(Size.SMALL);
        pizza.setCrust(Crust.STUFFED);
        return pizza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken(Size.SMALL);
        pizza.setCrust(Crust.PAN);
        return pizza;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn(Size.SMALL);
        pizza.setCrust(Crust.PAN);
        return pizza;
    }

}
