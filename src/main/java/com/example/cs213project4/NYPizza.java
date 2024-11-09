package com.example.cs213project4;

public class NYPizza implements PizzaFactory{

    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe(Size.SMALL);
        pizza.setCrust(Crust.BROOKLYN);
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza(Size.SMALL);
        pizza.setCrust(Crust.HANDTOSSED);
        return pizza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken(Size.SMALL);
        pizza.setCrust(Crust.THIN);
        return pizza;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn(Size.SMALL);
        pizza.setCrust(Crust.HANDTOSSED);
        return pizza;
    }
}
