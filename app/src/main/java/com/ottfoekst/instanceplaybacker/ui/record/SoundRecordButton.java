package com.ottfoekst.instanceplaybacker.ui.record;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.ottfoekst.instanceplaybacker.model.entity.SoundRecorder;
import com.ottfoekst.instanceplaybacker.model.entity.SoundRecorderFactory;

public class SoundRecordButton extends AppCompatButton {
    private final String fileName;
    private SoundRecorder recorder;
    private boolean mStartRecording = true;

    private View.OnClickListener clicker = new View.OnClickListener() {
        public void onClick(View v) {
            onRecord(mStartRecording);
            if (mStartRecording) {
                setText("Stop recording");
            } else {
                setText("Start recording");
            }
            mStartRecording = !mStartRecording;
        }
    };

    public SoundRecordButton(Context ctx, String fileName) {
        super(ctx);
        this.fileName = fileName;
        setText("Start recording");
        setOnClickListener(clicker);
    }

    private void onRecord(boolean start) {
        if (start) {
            recorder = SoundRecorderFactory.createStarted(fileName);
        } else {
            recorder.stop();
            recorder = null;
        }
    }

    public void stop() {
        if (recorder != null) {
            recorder.forceStop();
            recorder = null;
        }
    }
}
