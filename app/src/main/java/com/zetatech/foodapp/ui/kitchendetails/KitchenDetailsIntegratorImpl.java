package com.zetatech.foodapp.ui.kitchendetails;


import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.models.ResponseKitchenDetails;
import com.zetatech.foodapp.data.network.webservice.BaseApi;
import com.zetatech.foodapp.ui.base.BaseIntegratorImp;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


class KitchenDetailsIntegratorImpl extends BaseIntegratorImp implements KitchenDetailsIntegrator {

    @Inject
    public KitchenDetailsIntegratorImpl(PreferencesOperation mPreferencesOp, BaseApi mApi) {
        super(mPreferencesOp, mApi);
    }



    // represents the connection for load Kitchens Data
    @Override
    public Observable<ResponseKitchenDetails> loadKitchensData(int kitchenId) {

       return getApi().getKitchensData(kitchenId)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

    }



}
