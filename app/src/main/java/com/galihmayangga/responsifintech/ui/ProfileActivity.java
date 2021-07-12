package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.database.DatabaseHelper;
import com.galihmayangga.responsifintech.database.ShowUserDataPref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {
    DatabaseHelper db;
    @BindView(R.id.etEmail) EditText  EditTextEmail;
    @BindView(R.id.etName) EditText EditTextName;
    @BindView(R.id.etAddress) EditText EditTextAddress;
    @BindView(R.id.btnSave) Button buttonSave;
    ShowUserDataPref showUserDataPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        db = new DatabaseHelper(this);
        ButterKnife.bind(this);
        showUserDataPref = new ShowUserDataPref(this);
       EditTextEmail.setText(showUserDataPref.getSPEmail());
        EditTextName.setText(showUserDataPref.getSPName());
        EditTextAddress.setText(showUserDataPref.getSPAddress());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = EditTextName.getText().toString();
                String strAddress = EditTextAddress.getText().toString();
                showUserDataPref.saveSPString(ShowUserDataPref.SP_NAME, strName);
                showUserDataPref.saveSPString(ShowUserDataPref.SP_ADDRESS, strAddress);
                showUserDataPref.saveSPBoolean(ShowUserDataPref.SP_SUDAH_OK, true);
                if (strName.equals(strName)) {
                    Boolean save = db.insertProfile(strName, strAddress);
                    if (save == true) {
                        Toast.makeText(getApplicationContext(), "Save Profile Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = getIntent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Save Profile Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });;

    }




}