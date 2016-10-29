package com.android.audiocamerapermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Button button;
    private Button button2;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                int hasCameraPermission;
                if (Build.VERSION.SDK_INT >= 23) {
                    hasCameraPermission = checkSelfPermission(Manifest.permission.CAMERA);
                } else {
                    hasCameraPermission = CameraPermissionCheckUtils.checkCameraPermission(this) ?
                            PackageManager.PERMISSION_GRANTED : PackageManager.PERMISSION_DENIED;
                }
                Toast.makeText(this, "camera granted : " + (hasCameraPermission == PackageManager.PERMISSION_GRANTED),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                int hasAudioPermission;
                if (Build.VERSION.SDK_INT >= 23) {
                    hasAudioPermission = checkSelfPermission(Manifest.permission.RECORD_AUDIO);
                } else {
                    hasAudioPermission = AudioPermissionCheckUtils.checkAudioPermission(this) ?
                            PackageManager.PERMISSION_GRANTED : PackageManager.PERMISSION_DENIED;
                }
                Toast.makeText(this, "audio granted : " + (hasAudioPermission == PackageManager.PERMISSION_GRANTED),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
