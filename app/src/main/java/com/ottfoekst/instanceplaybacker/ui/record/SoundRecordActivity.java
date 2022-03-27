package com.ottfoekst.instanceplaybacker.ui.record;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ottfoekst.instanceplaybacker.R;
import com.ottfoekst.instanceplaybacker.model.data.SoundData;

public class SoundRecordActivity extends AppCompatActivity {
    private SoundRecordButton recordButton = null;
    private SoundPlayButton playButton = null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sound_record);

        SoundData data = new SoundData(getExternalCacheDir().getAbsolutePath() + "/audiorecordtest.3gp");

        recordButton = findViewById(R.id.record_button);
        recordButton.setFileName(data.getFileName());

        playButton = findViewById(R.id.play_button);
        playButton.setFileName(data.getFileName());
    }

    @Override
    public void onStop() {
        super.onStop();
        recordButton.stop();
        playButton.stop();
    }

}