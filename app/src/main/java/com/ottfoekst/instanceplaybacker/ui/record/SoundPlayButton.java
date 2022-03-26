package com.ottfoekst.instanceplaybacker.ui.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.ottfoekst.instanceplaybacker.model.entity.SoundPlayer;
import com.ottfoekst.instanceplaybacker.model.entity.SoundPlayerFactory;

import lombok.Setter;

public class SoundPlayButton extends AppCompatButton {
    @Setter
    private String fileName;
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

    public SoundPlayButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
