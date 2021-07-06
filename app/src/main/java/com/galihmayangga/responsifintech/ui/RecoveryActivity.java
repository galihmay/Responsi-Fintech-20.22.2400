package com.galihmayangga.responsifintech.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.galihmayangga.responsifintech.R;

public class RecoveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Recovery Account");
        setContentView(R.layout.activity_recovery);
    }

    public void Login(View view) {
        Intent intent = new Intent(RecoveryActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}