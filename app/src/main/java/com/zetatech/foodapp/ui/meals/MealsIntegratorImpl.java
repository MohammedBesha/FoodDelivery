package com.zetatech.foodapp.ui.meals;


import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.models.ResponseMenuDetails;
import com.zetatech.foodapp.data.network.webservice.BaseApi;
import com.zetatech.foodapp.ui.base.BaseIntegratorImp;

import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


class MealsIntegratorImpl extends BaseIntegratorImp implements MealsIntegrator {

    @Inject
    public MealsIntegratorImpl(PreferencesOperation mPreferencesOp, BaseApi mApi) {
        super(mPreferencesOp, mApi);
    }


    // represents the connection for load Menu Details
    @Override
    public Observable<ResponseMenuDetails> loadMenuDetails(int menuId ) {

       return getApi().getMenuDetails(menuId)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

    }



}
