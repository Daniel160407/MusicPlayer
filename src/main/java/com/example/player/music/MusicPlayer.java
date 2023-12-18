package com.example.player.music;

import com.example.player.threads.MusicPlayerThread;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.File;
import java.io.FileInputStream;

public class MusicPlayer {
    private AdvancedPlayer currentPlayer;

    public void playMP3(File mp3FilePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(mp3FilePath);
        currentPlayer = new AdvancedPlayer(fileInputStream);

        Thread thread = new Thread(new MusicPlayerThread(currentPlayer));
        thread.start();
    }
}
