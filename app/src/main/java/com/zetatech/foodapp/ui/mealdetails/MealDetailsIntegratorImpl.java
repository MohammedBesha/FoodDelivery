package com.zetatech.foodapp.ui.mealdetails;


import com.zetatech.foodapp.data.local.prefs.PreferencesOperation;
import com.zetatech.foodapp.data.models.ResponseMealDetails;
import com.zetatech.foodapp.data.network.webservice.BaseApi;
import com.zetatech.foodapp.ui.base.BaseIntegratorImp;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


class MealDetailsIntegratorImpl extends BaseIntegratorImp implements MealDetailsIntegrator {

    @Inject
    public MealDetailsIntegratorImpl(PreferencesOperation mPreferencesOp, BaseApi mApi) {
        super(mPreferencesOp, mApi);
    }


    // represents the connection for load Meal Details
    @Override
    public Observable<ResponseMealDetails> loadMealDetails(int mealId) {
        return getApi().getMealDetails(mealId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


}
