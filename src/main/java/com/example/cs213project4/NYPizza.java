package com.example.cs213project4;

public class NYPizza {

    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Size.SMALL, Crust.THIN);
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Size.SMALL, Crust.HANDTOSSED);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Size.SMALL, Crust.THIN);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Size.SMALL, Crust.HANDTOSSED);
    }
}
