package com.example.renterproject2;

import com.example.renterproject2.models.Cars;
import com.example.renterproject2.services.CarServices;
import com.example.renterproject2.services.impl.CarServicesImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Главная страница !");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {

        launch();

    }
}