package com.ottfoekst.instanceplaybacker.model.entity;

import android.media.MediaPlayer;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SoundPlayer {
    private final MediaPlayer player;

    public void start() throws IOException {
        player.prepare();
        player.start();
    }

    public void stop() {
        player.release();
    }
}
