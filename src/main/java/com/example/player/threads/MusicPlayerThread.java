package com.example.player.threads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayerThread implements Runnable{
    private final AdvancedPlayer player;

    public MusicPlayerThread(AdvancedPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {
        new Thread(() -> {
            while (true) {
                if (Thread.activeCount() > 10) {
                    player.close();
                    break;
                }
            }
        }).start();
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
