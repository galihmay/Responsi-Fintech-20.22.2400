package com.galihmayangga.responsifintech.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.galihmayangga.responsifintech.R;
import com.galihmayangga.responsifintech.view.MvvmView;

import static androidx.core.content.ContextCompat.startActivity;

public class HomeViewModel implements HomeMvvm.ViewModel {

    private final HomeMvvm.View view;

    public final ObservableField<Drawable> homeTabDrawable = new ObservableField<>();
    public final ObservableField<Drawable> paymentTabDrawable = new ObservableField<>();
    public final ObservableField<Drawable> historyTabDrawable = new ObservableField<>();
    public final ObservableField<Drawable> settingTabDrawable = new ObservableField<>();


    public final ObservableField<String> homeTabText = new ObservableField<>("");
    public final ObservableField<String> paymentTabText = new ObservableField<>("");
    public final ObservableField<String> historyTabText = new ObservableField<>("");
    public final ObservableField<String> settingTabText = new ObservableField<>("");
    Context mContext;


    public HomeViewModel(MvvmView mvvmView) {
        view = (HomeMvvm.View) mvvmView;
        onTabSelected(TAB.HOME);
    }

    @Override
    public void onTabSelected(TAB tab) {
        resetTabs();
        switch (tab) {
            case HOME:
                homeTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_home_dark));
                homeTabText.set(view.getContext().getString(R.string.home));
                showHomeFragment();
                break;
            case PAYMENT:
                paymentTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_payment_dark));
                paymentTabText.set(view.getContext().getString(R.string.payment));
                showPaymentFragment();
                break;
            case HISTORY:
                historyTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_history_dark));
                historyTabText.set(view.getContext().getString(R.string.history));
                showHistoryFragment();
                break;
            case SETTING:
                settingTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_setting_dark));
                settingTabText.set(view.getContext().getString(R.string.settings));
                showSettingsFragment();
                break;
        }
    }




    private void resetTabs() {
        homeTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_home_light));
        paymentTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_payment_light));
        historyTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_history_light));
        settingTabDrawable.set(view.getContext().getResources().getDrawable(R.drawable.ic_setting_light));
        homeTabText.set("Home");
        paymentTabText.set("Payment");
        historyTabText.set("History");
        settingTabText.set("Settings");

    }

    private void showHomeFragment() {
        replaceFragment(new HomeFragment());
    }
    private void showPaymentFragment() {
        replaceFragment(new PaymentFragment());
    }
    private void showHistoryFragment() {
        replaceFragment(new HistoryFragment());
    }
    private void showSettingsFragment() {
        replaceFragment(new SettingFragment());
    }



    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
        transaction.replace(view.getFragmentContainer(), fragment);
        transaction.commit();
    }




}

