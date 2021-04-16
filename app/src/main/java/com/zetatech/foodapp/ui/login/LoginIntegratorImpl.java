package com.zetatech.foodapp.ui.login;



import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.models.LoginData;
import com.zetatech.foodapp.data.models.ResponseLogin;
import com.zetatech.foodapp.data.network.webservice.BaseApi;
import com.zetatech.foodapp.ui.base.BaseIntegratorImp;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class LoginIntegratorImpl extends BaseIntegratorImp implements LoginIntegrator {


    @Inject
    public LoginIntegratorImpl(PreferencesOperation mPreferencesOp, BaseApi mApi) {
        super(mPreferencesOp, mApi);
    }

    //represents the connection for login
    @Override
    public Observable<ResponseLogin> login(String phoneNumber, int countryCodeLookupID, String password) {
        return getApi().login(phoneNumber, countryCodeLookupID, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


    }

    //represents storing user data in shared preference
    @Override
    public void saveUserLogin(LoginData loginData) {

        getPreferencesOp().putUserIsSignIn(true);
        getPreferencesOp().putUserData(loginData.getId(), loginData.getFirstName(),
                                        loginData.getPhone(), loginData.getLocation().getCityName(),
                                        loginData.getLocation().getAreaId());

    }


}
