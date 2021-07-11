package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button buttonRegister;
    EditText EditTextEmail, EditTextPassword, EditTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Register Account");
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        EditTextEmail = (EditText)findViewById(R.id.etEmailReg);
        EditTextPassword = (EditText)findViewById(R.id.etPasswordReg);
        EditTextConfirmPassword = (EditText)findViewById(R.id.etConfirmPasswordReg);
        buttonRegister = (Button) findViewById(R.id.btnRegister);



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = EditTextEmail.getText().toString();
                String strPassword = EditTextPassword.getText().toString();
                String strPasswordConf = EditTextConfirmPassword.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean daftar = db.insertUser(strEmail, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent Intent = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(Intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });;
    }
}