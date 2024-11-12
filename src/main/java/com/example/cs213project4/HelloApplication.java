package com.example.cs213project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.sql.SQLOutput;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
        Pizza testDeluxe = new Deluxe(Size.SMALL);
        System.out.println(testDeluxe.price());
        for(Topping t:testDeluxe.getToppings()){
            System.out.println(t);
        }
        Pizza testBBQChicken = new BBQChicken(Size.SMALL);
        System.out.println(testBBQChicken.price());
        for(Topping t:testBBQChicken.getToppings()){
            System.out.println(t);
        }
        Pizza testMeatzza = new Meatzza(Size.SMALL);
        System.out.println(testMeatzza.price());
        for(Topping t:testMeatzza.getToppings()){
            System.out.println(t);
        }
        BuildYourOwn testBuildYourOwn = new BuildYourOwn(Size.SMALL);
        testBuildYourOwn.addTopping(Topping.ONION);
        for(Topping t:testBuildYourOwn.getToppings()){
            System.out.println(t);
        }
        System.out.println(testBuildYourOwn.price());
    }
}