package com.ottfoekst.instanceplaybacker.ui.record;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ottfoekst.instanceplaybacker.R;
import com.ottfoekst.instanceplaybacker.model.data.SoundData;
import com.ottfoekst.instanceplaybacker.model.repository.SoundDataRepositorySingleton;
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

        recordButton = findViewById(R.id.recordButton);
        recordButton.setSoundable(new RepeatSoundRecorder(getFileName()));

        playButton = findViewById(R.id.playButton);
        playButton.setSoundable(new RepeatSoundPlayer(getFileName()));
    }

    @NonNull
    private String getFileName() {
        return getExternalCacheDir().getAbsolutePath() + "/audiorecordtest.3gp";
    }

    @Override
    public void onStop() {
        super.onStop();
        recordButton.stop();
        playButton.stop();
    }

    public void registerSoundData(View view) {
        EditText nameEditText = findViewById(R.id.nameEditText);
        SoundData soundData = new SoundData(1, nameEditText.getText().toString(), getFileName());
        SoundDataRepositorySingleton.getInstance().put(soundData);
        Log.d(SoundRecordActivity.class.getSimpleName(), "soundData = " + SoundDataRepositorySingleton.getInstance().getSoundData(1));
    }
}