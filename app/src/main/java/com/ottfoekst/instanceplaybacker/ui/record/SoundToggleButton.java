package com.ottfoekst.instanceplaybacker.ui.record;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatToggleButton;

import com.ottfoekst.instanceplaybacker.model.service.sound.Soundable;

import lombok.Setter;

public class SoundToggleButton extends AppCompatToggleButton {
    @Setter
    private Soundable soundable;

    public SoundToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnCheckedChangeListener((button, isChecked) -> {
            if (isChecked) {
                soundable.start();
            } else {
                soundable.stop();
            }
        });
    }

    public void stop() {
        soundable.forceStop();
    }
}
