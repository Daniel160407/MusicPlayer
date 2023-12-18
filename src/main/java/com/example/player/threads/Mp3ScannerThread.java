package com.example.player.threads;

import com.example.player.controllers.HomeController;
import com.example.player.music.AddNewMusic;
import com.example.player.scanners.MP3Scanner;
import javafx.application.Platform;

import java.io.File;

public class Mp3ScannerThread implements Runnable {
    private HomeController homeController;

    public Mp3ScannerThread(HomeController homeController) {
        this.homeController = homeController;
    }

    @Override
    public void run() {
        MP3Scanner mp3Scanner = new MP3Scanner();
        mp3Scanner.scanMp3Files();

        AddNewMusic addNewMusic = new AddNewMusic();
        for (File file : mp3Scanner.getMp3Files()) {
            addNewMusic.addNewMusic(file);
        }

        addNewMusic.designAllMusics();

        homeController.setMusics(addNewMusic.getDesignedMusicList());
        Platform.runLater(() -> homeController.displayMusics());
    }
}
