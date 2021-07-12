package com.galihmayangga.responsifintech.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.database.ShowUserDataPref;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {

    @BindView(R.id.tvResultEmail)
    TextView tvResultEmail;


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        ShowUserDataPref showUserDataPref = new ShowUserDataPref(getActivity());
        tvResultEmail.setText(showUserDataPref.getSPEmail());


  return view;
    }
}
