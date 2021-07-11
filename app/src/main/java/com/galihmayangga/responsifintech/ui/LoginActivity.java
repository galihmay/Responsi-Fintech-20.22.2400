package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
   Button buttonLogin;
   EditText EditTextEmail, EditTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        EditTextEmail = (EditText)findViewById(R.id.etEmailLog);
        EditTextPassword = (EditText)findViewById(R.id.etPasswordLog);
        buttonLogin = (Button) findViewById(R.id.btnLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = EditTextEmail.getText().toString();
                String strPassword = EditTextPassword.getText().toString();
                Boolean masuk = db.checkLogin(strUsername, strPassword);
                if (masuk == true) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
                    if (updateSession == true) {
                        Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                        Intent Intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(Intent);
                        finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Gagal, Periksa Email & Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Recovery(View view) {
        Intent intent = new Intent(LoginActivity.this, RecoveryActivity.class);
        startActivity(intent);
    }

    public void Register(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


}