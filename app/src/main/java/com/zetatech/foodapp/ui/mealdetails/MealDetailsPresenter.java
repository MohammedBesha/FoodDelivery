package com.zetatech.foodapp.ui.mealdetails;


import com.zetatech.foodapp.data.models.MealDetailsData;
import com.zetatech.foodapp.data.models.ResponseMealDetails;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import com.zetatech.foodapp.utils.Constants;
import javax.inject.Inject;
import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class MealDetailsPresenter extends BasePresenterImp<MealDetailsContract.View, MealDetailsIntegrator>
        implements MealDetailsContract.Presenter {


    @Inject
    public MealDetailsPresenter(MealDetailsIntegrator mIntegrator, CompositeDisposable compositeDisposable) {
        super(mIntegrator, compositeDisposable);
    }


    @Override
    public void loadMealDetailsProcess(int mealId) {

        getView().hideContentLayout();

        if (getView().isNetworkConnected()) {
            getView().showLoading();

            addDisposable(getIntegrator().loadMealDetails(mealId)
                    .subscribe(this::subscribe, this::onError));

        } else {

            controlNoConnection();
        }


    }


    private void subscribe(ResponseMealDetails response) {

        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();

        if (response.getStatusCode() == Constants.SUCCESS_STATUS_CODE && response.getStatus().equals(Constants.SUCCESS_STATUS)) {

            MealDetailsData data = response.getData();

            if (data != null ) {
                getView().showContentLayout();
                getView().setMealDetailsData(data);

            } else {
                getView().hideContentLayout();
                getView().showEmptyLisView();
            }
        }
    }

    private void onError(Throwable throwable) {


        getView().showErrorConnection();
        getView().hideContentLayout();
        getView().hideLoading();
        getView().showErrorView();

    }


    private void controlNoConnection() {

        getView().hideContentLayout();
        getView().hideLoading();
        getView().showNoConnectionView();
    }


}
