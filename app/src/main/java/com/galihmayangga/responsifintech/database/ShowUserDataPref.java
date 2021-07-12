package com.galihmayangga.responsifintech.database;
import android.content.Context;
import android.content.SharedPreferences;

public class ShowUserDataPref {
    public static final String SP_APKBAYARDULU = "spApkBayarDulu";


    public static final String SP_EMAIL = "spEmail";
    public static final String SP_NAME = "spName";
    public static final String SP_ADDRESS = "spAddress";
    public static final String SP_SUDAH_OK = "spSudahOk";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public ShowUserDataPref(Context context){
        sp = context.getSharedPreferences(SP_APKBAYARDULU, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }


    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }
    public String getSPName(){
        return sp.getString(SP_NAME, "");
    }
    public String getSPAddress(){
        return sp.getString(SP_ADDRESS, "");
    }
    public Boolean getSPSudahOk(){ return sp.getBoolean(SP_SUDAH_OK, false);
    }
}