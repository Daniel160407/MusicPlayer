package com.example.player.scanners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MP3Scanner {
    private final String directoryPath = "F:\\";
    private List<File> mp3Files;

    public void scanMp3Files() {
        mp3Files = findMP3Files(directoryPath);

        System.out.println("MP3 Files found:");
        System.out.println(mp3Files.size());
        for (File mp3File : mp3Files) {
            System.out.println(mp3File.getAbsolutePath());
        }
    }

    public List<File> findMP3Files(String directoryPath) {
        List<File> mp3Files = new ArrayList<>();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory doesn't exist.");
            return mp3Files;
        }
        searchForMP3Files(directory, mp3Files);
        return mp3Files;
    }

    private void searchForMP3Files(File file, List<File> mp3Files) {
        if (file.isDirectory()) {
            File[] directoryFiles = file.listFiles();
            if (directoryFiles != null) {
                for (File f : directoryFiles) {
                    searchForMP3Files(f, mp3Files);
                }
            }
        } else {
            if (file.getName().toLowerCase().endsWith(".mp3")) {
                mp3Files.add(file);
            }
        }
    }

    public List<File> getMp3Files() {
        return mp3Files;
    }
}
