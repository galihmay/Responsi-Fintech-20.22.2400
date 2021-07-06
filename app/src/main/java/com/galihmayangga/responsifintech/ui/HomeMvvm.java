package com.galihmayangga.responsifintech.ui;

import android.content.Context;

import com.galihmayangga.responsifintech.view.MvvmView;


public class HomeMvvm {
    public interface View extends MvvmView {

        Context getContext();

        @IdRes int getFragmentContainer();
    }

    public interface ViewModel {
        enum TAB {
            HOME,
            PAYMENT,
            HISTORY,
            SETTING
        }

        void onTabSelected(TAB tab);

    }
}