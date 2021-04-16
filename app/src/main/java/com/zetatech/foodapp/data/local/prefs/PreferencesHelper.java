package com.zetatech.foodapp.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class PreferencesHelper {


    private static final String PREF_FILE_NAME = "zetatech";
    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper( @ApplicationContext Context context){

        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

    }


    public void clear() {
        mPref.edit().clear().apply();
    }

    public void putString(String key,String value) {
        mPref.edit().putString(key, value).apply();
    }

    public void putInt(String key,int value) {
        mPref.edit().putInt(key, value).apply();
    }


    public void putBoolean(String key,boolean value) {

        mPref.edit().putBoolean(key, value).apply();
    }



    public int getInt(String key) {
        return mPref.getInt(key, 0);
    }

    public String getString(String key) {
        return mPref.getString(key, null);
    }

    public Boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }
}
