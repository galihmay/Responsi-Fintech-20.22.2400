package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.galihmayangga.responsifintech.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Payment");
        setContentView(R.layout.activity_payment);
    }

    public void Home(View view) {
        Intent intent = new Intent(PaymentActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}