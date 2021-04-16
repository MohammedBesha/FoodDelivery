package com.zetatech.foodapp.ui.dashboard;



import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.models.ResponseDashboard;
import com.zetatech.foodapp.data.models.UserData;
import com.zetatech.foodapp.data.network.webservice.BaseApi;
import com.zetatech.foodapp.ui.base.BaseIntegratorImp;

import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


class DashboardIntegratorImpl extends BaseIntegratorImp implements DashboardIntegrator {

    @Inject
    public DashboardIntegratorImpl(PreferencesOperation mPreferencesOp, BaseApi mApi) {
        super(mPreferencesOp, mApi);
    }


    @Override
    public int getAreaId() {
        return getPreferencesOp().getAreaId();

    }


    //Represents the connection for  load Dashboard Data
    @Override
    public Observable<ResponseDashboard> loadDashboardData(int areaId) {

       return getApi().getDashboardData(areaId)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

    }



}
