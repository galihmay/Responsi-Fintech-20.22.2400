package com.galihmayangga.responsifintech.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.galihmayangga.responsifintech.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.galihmayangga.responsifintech.databinding.ActivityHomeBinding;



public class HomeActivity extends AppCompatActivity implements HomeMvvm.View {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setVm(new HomeViewModel(this));


    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public int getFragmentContainer() {
        return R.id.container;
    }


}