package com.ottfoekst.instanceplaybacker.ui.record;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.ottfoekst.instanceplaybacker.model.entity.SoundPlayer;
import com.ottfoekst.instanceplaybacker.model.entity.SoundPlayerFactory;

public class SoundPlayButton extends AppCompatButton {
    private final String fileName;
    private SoundPlayer player = null;
    private boolean mStartPlaying = true;

    View.OnClickListener clicker = new View.OnClickListener() {
        public void onClick(View v) {
            onPlay(mStartPlaying);
            if (mStartPlaying) {
                setText("Stop playing");
            } else {
                setText("Start playing");
            }
            mStartPlaying = !mStartPlaying;
        }
    };

    public SoundPlayButton(Context ctx, String fileName) {
        super(ctx);
        this.fileName = fileName;
        setText("Start playing");
        setOnClickListener(clicker);
    }

    private void onPlay(boolean start) {
        if (start) {
            player = SoundPlayerFactory.createStarted(fileName);
        } else {
            player.stop();
            player = null;
        }
    }

    public void stop() {
        if (player != null) {
            player.stop();
        }
    }
}
