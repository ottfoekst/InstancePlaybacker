package com.ottfoekst.instanceplaybacker.ui.record;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.ottfoekst.instanceplaybacker.model.data.SoundData;

public class SoundRecordActivity extends AppCompatActivity {
    // TODO どこかに定数定義されてないの？
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

    private SoundData data;
    private SoundRecordButton recordButton = null;
    private SoundPlayButton playButton = null;

    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

    // TODO パーミッション設定は最初のActivityに置くべき
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) {
            finish();
        }
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // TODO activity_sound_record.xmlの反映。その際findViewByIdを使ってButtonを取得？

        data = new SoundData(getExternalCacheDir().getAbsolutePath() + "/audiorecordtest.3gp");

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        LinearLayout ll = new LinearLayout(this);
        recordButton = new SoundRecordButton(this, data.getFileName());
        ll.addView(recordButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        playButton = new SoundPlayButton(this, data.getFileName());
        ll.addView(playButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        setContentView(ll);
    }

    @Override
    public void onStop() {
        super.onStop();
        recordButton.stop();
        playButton.stop();
    }

}