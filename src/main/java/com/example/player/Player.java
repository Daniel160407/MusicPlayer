package com.example.player;

import com.example.player.controllers.HomeController;
import com.example.player.scanners.MP3Scanner;
import com.example.player.threads.Mp3ScannerThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Player extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Player.class.getResource("fxml files/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 483, 799);
        stage.setTitle("Player");
        stage.setScene(scene);
        stage.show();
        HomeController homeController = fxmlLoader.getController();
        Thread thread = new Thread(new Mp3ScannerThread(homeController));
        thread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}