package com.example.cs213project4;

public class ChicagoPizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Size.SMALL, Crust.DEEPDISH);
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Size.SMALL, Crust.STUFFED);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Size.SMALL, Crust.PAN);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Size.SMALL, Crust.THIN);
    }

}
