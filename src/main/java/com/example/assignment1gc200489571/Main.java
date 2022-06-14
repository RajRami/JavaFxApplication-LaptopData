package com.example.assignment1gc200489571;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Laptop> laptops = DBUtility.getLaptopsFromDB();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Laptop Store");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}