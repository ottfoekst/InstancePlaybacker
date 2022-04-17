package com.ottfoekst.instanceplaybacker.ui.record;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ottfoekst.instanceplaybacker.R;
import com.ottfoekst.instanceplaybacker.model.service.sound.RepeatSoundPlayer;
import com.ottfoekst.instanceplaybacker.model.service.sound.RepeatSoundRecorder;
import com.ottfoekst.instanceplaybacker.ui.view.SoundToggleButton;

public class SoundRecordActivity extends AppCompatActivity {
    private SoundToggleButton recordButton = null;
    private SoundToggleButton playButton = null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sound_record);

        String fileName = getExternalCacheDir().getAbsolutePath() + "/audiorecordtest.3gp";

        recordButton = findViewById(R.id.recordButton);
        recordButton.setSoundable(new RepeatSoundRecorder(fileName));

        playButton = findViewById(R.id.playButton);
        playButton.setSoundable(new RepeatSoundPlayer(fileName));
    }

    @Override
    public void onStop() {
        super.onStop();
        recordButton.stop();
        playButton.stop();
    }

}