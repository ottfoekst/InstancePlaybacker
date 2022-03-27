package com.ottfoekst.instanceplaybacker.model.service;

import android.Manifest;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PermissionRequestService {
    public static void request(ComponentActivity activity) {
        ActivityResultLauncher<String> launcher = activity.registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
            if (!result) {
                activity.finish();
            }
        });
        launcher.launch(Manifest.permission.RECORD_AUDIO);
    }
}
