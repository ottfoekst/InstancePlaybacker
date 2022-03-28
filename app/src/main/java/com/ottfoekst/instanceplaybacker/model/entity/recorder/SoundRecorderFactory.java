package com.ottfoekst.instanceplaybacker.model.entity.recorder;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SoundRecorderFactory {
    public static SoundRecorder createStarted(String fileName) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            SoundRecorder soundRecorder = new SoundRecorder(mediaRecorder);
            soundRecorder.start();
            return soundRecorder;
        } catch (IOException e) {
            // TODO メソッド名を取得したい
            Log.e(SoundRecorderFactory.class.getSimpleName(), "createStarted() failed");
            return null;
        }
    }
}
