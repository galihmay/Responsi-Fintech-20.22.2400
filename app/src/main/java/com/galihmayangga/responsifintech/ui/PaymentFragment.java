package com.galihmayangga.responsifintech.ui;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galihmayangga.responsifintech.R;


public class PaymentFragment extends Fragment {



    public PaymentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        TextView txtpaymentcode = view.findViewById(R.id.txtpaymentcode);
        txtpaymentcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PaymentActivity.class));
            }
        });

    return  view;
    }
}