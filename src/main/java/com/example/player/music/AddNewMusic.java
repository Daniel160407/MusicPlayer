package com.example.player.music;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewMusic {
    private final List<File> musics = new ArrayList<>();
    private final List<StackPane> designedMusicList = new ArrayList<>();

    public void addNewMusic(File musicFile) {
        musics.add(musicFile);
    }

    public void designAllMusics() {
        int previousYPath = 0;
        for (File music : musics) {
            StackPane stackPane = new StackPane();
            stackPane.setLayoutX(35);
            stackPane.setLayoutY(previousYPath + 50);
            previousYPath += 55;
            Rectangle rec = new Rectangle(420, 50, Color.web("#374151"));
            stackPane.setOnMouseClicked(event -> {
                System.out.println(music);
                try {
                    MusicPlayer musicPlayer = new MusicPlayer();
                    musicPlayer.playMP3(music);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            String patternString = "\\\\([^\\\\]+) - ([^\\\\]+)\\.mp3";
            String singer = null;
            String song = null;
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(music.toString());
            if (matcher.find()) {
                singer = matcher.group(1);
                song = matcher.group(2);
            }
            Label singerLabel = new Label();
            singerLabel.setText(singer);
            singerLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: white;");
            Label songLabel = new Label();
            songLabel.setText(song);
            songLabel.setStyle("-fx-font-size: 15px; -fx-text-fill: white;");
            VBox vBox = new VBox();
            vBox.getChildren().addAll(songLabel, singerLabel);
            stackPane.getChildren().addAll(rec, vBox);
            designedMusicList.add(stackPane);
        }
    }

    public List<File> getMusics() {
        return musics;
    }

    public List<StackPane> getDesignedMusicList() {
        return designedMusicList;
    }
}
