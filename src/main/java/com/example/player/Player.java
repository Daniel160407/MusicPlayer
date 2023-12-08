package com.example.player;

import com.example.player.scanners.MP3Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Player extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Player.class.getResource("fxml files/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Player");
        stage.setScene(scene);
        stage.show();
        MP3Scanner mp3Scanner = new MP3Scanner();
        new Thread(mp3Scanner::scanMp3Files).start();
    }

    public static void main(String[] args) {
        launch();
    }
}