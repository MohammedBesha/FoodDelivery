package com.zetatech.foodapp.ui.base;


import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.network.webservice.BaseApi;

public interface BaseInteractor{


    PreferencesOperation getPreferencesOp();

    BaseApi getApi();


}