package com.ottfoekst.instanceplaybacker.model.entity.player;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SoundPlayerFactory {
    public static SoundPlayer createStarted(String fileName) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(fileName);
            SoundPlayer player = new SoundPlayer(mediaPlayer);
            player.start();
            return player;
        } catch (IOException e) {
            // TODO メソッド名を取得したい
            Log.e(SoundPlayerFactory.class.getSimpleName(), "createStarted() failed");
            return null;
        }
    }
}
