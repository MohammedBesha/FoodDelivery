package com.zetatech.foodapp.ui.login;


import com.zetatech.foodapp.data.models.LoginData;
import com.zetatech.foodapp.data.models.ResponseLogin;
import com.zetatech.foodapp.ui.base.BaseInteractor;

import io.reactivex.rxjava3.core.Observable;

public interface LoginIntegrator extends BaseInteractor {

    Observable<ResponseLogin> login(String phone, int countryCodeLookupID , String password);

    void saveUserLogin(LoginData loginData);

  }
