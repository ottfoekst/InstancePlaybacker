package com.ottfoekst.instanceplaybacker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ottfoekst.instanceplaybacker.model.service.PermissionRequestService;
import com.ottfoekst.instanceplaybacker.ui.record.SoundRecordActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PermissionRequestService.request(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public void startSoundRecord(MenuItem menuItem) {
        Intent intent = new Intent(this, SoundRecordActivity.class);
        startActivity(intent);
    }
}