package com.example.player.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    @FXML
    private AnchorPane mainAnchorPane;

    private List<StackPane> musics;

    public void displayMusics() {
        for (StackPane stackPane : musics) {
            mainAnchorPane.getChildren().add(stackPane);
            mainAnchorPane.setPrefHeight(mainAnchorPane.getPrefHeight() + 55);
        }
    }

    public void setMusics(List<StackPane> musics) {
        this.musics = musics;
    }
}