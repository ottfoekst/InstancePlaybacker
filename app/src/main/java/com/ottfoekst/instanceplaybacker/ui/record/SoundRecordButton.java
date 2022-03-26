package com.ottfoekst.instanceplaybacker.ui.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.ottfoekst.instanceplaybacker.model.entity.SoundRecorder;
import com.ottfoekst.instanceplaybacker.model.entity.SoundRecorderFactory;

import lombok.Setter;

public class SoundRecordButton extends AppCompatButton {
    @Setter
    private String fileName;
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

    public SoundRecordButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
