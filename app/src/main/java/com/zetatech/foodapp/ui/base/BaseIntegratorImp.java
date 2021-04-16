

package com.zetatech.foodapp.ui.base;


import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.network.webservice.BaseApi;

//Represents Base Integrator implements
public class BaseIntegratorImp implements BaseInteractor {

    private PreferencesOperation mPreferencesOp;
    private BaseApi mApi;

    public BaseIntegratorImp(PreferencesOperation mPreferencesOp,
                             BaseApi mApi) {
        this.mPreferencesOp = mPreferencesOp;
        this.mApi = mApi;
    }

    @Override
    public BaseApi getApi() {
        return mApi;
    }

    @Override
    public PreferencesOperation getPreferencesOp() {
        return mPreferencesOp;
    }



}
