package com.galihmayangga.responsifintech.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galihmayangga.responsifintech.R;


public class SettingFragment extends Fragment {

    public SettingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        CardView btnprofile = view.findViewById(R.id.btnProfile);
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });


        CardView btnaccountbank = view.findViewById(R.id.btnAccuntBank);
        btnaccountbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AccountBankActivity.class));
            }
        });

        CardView btncreditcard = view.findViewById(R.id.btnCreditCard);
       btncreditcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreditCardActivity.class));
            }
        });

        CardView btnpassword = view.findViewById(R.id.btnPassword);
        btnpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PasswordActivity.class));
            }
        });

        CardView btnhelp = view.findViewById(R.id.btnHelp);
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HelpActivity.class));
            }
        });



        return  view;
    }
}