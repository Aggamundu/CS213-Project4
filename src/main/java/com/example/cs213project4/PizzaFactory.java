package com.example.cs213project4;

public interface PizzaFactory {

    Pizza createDeluxe(String size);

    Pizza createMeatzza(String size);

    Pizza createBBQChicken(String size);

    Pizza createBuildYourOwn(String size);
}
