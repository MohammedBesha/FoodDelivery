package com.zetatech.foodapp.data.local.prefs;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesOperation {


    private PreferencesHelper preferencesHelper;

    private static final String KEY_USER_IS_LOGIN = "keyUserIsLogin";
    private static final String KEY_USER_ID = "keyUserID";
    private static final String KEY_USER_NAME = "keyUserName";
    private static final String KEY_USER_PHONE = "keyUserPhone";
    private static final String KEY_CITY_NAME = "keyCityName";
    private static final String KEY_AREA_ID = "keyAreaId";


    @Inject
    public PreferencesOperation(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }


    ////Represents storing logged in status
    public void putUserIsSignIn(boolean done) {
        preferencesHelper.putBoolean(KEY_USER_IS_LOGIN, done);
    }


    //Represents logged in status
    public Boolean getUserIsSignIn() {
        int userID = getUserID();
        return preferencesHelper.getBoolean(KEY_USER_IS_LOGIN) && userID != 0;
    }

    //Represents storing user data
    public void putUserData(long userId, String fullName, String phone, String cityName,long areaId) {

        preferencesHelper.putInt(KEY_USER_ID, (int)userId);
        preferencesHelper.putString(KEY_USER_NAME, fullName);
        preferencesHelper.putString(KEY_USER_PHONE, phone);
        preferencesHelper.putString(KEY_CITY_NAME, cityName);
        preferencesHelper.putInt(KEY_AREA_ID, (int)areaId);

    }


    //Represents get user id
    public int getUserID() {
        return preferencesHelper.getInt(KEY_USER_ID);
    }


    public int getAreaId() {
        return preferencesHelper.getInt(KEY_AREA_ID);
    }


    public void clearUserData() {
        preferencesHelper.clear();
    }




}
