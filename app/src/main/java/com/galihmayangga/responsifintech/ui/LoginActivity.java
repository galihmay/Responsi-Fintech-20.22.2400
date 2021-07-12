package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.database.DatabaseHelper;
import com.galihmayangga.responsifintech.database.ShowEmailPref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;


    @BindView(R.id.etEmailLog) EditText  EditTextEmail;
    @BindView(R.id.etPasswordLog) EditText EditTextPassword;
    @BindView(R.id.btnLogin) Button buttonLogin;
    ShowEmailPref showEmailPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        ButterKnife.bind(this);
        showEmailPref = new ShowEmailPref(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = EditTextEmail.getText().toString();
                String strPassword = EditTextPassword.getText().toString();
                Boolean masuk = db.checkLogin(strEmail, strPassword);
                showEmailPref.saveSPString(ShowEmailPref.SP_EMAIL, strEmail);
                showEmailPref.saveSPBoolean(ShowEmailPref.SP_SUDAH_LOGIN, true);
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