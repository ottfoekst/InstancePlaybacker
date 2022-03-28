package com.ottfoekst.instanceplaybacker.model.entity.recorder;

import android.media.MediaRecorder;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SoundRecorder {
    private final MediaRecorder recorder;

    public void start() throws IOException {
        recorder.prepare();
        recorder.start();
    }

    public void stop() {
        recorder.stop();
        recorder.release();
    }

    public void forceStop() {
        recorder.release();
    }
}
