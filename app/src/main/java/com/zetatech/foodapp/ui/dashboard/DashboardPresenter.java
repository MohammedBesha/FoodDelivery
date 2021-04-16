package com.zetatech.foodapp.ui.dashboard;


import android.util.Log;

import com.zetatech.foodapp.data.models.DashboardData;
import com.zetatech.foodapp.data.models.ResponseDashboard;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import com.zetatech.foodapp.utils.Constants;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class DashboardPresenter extends BasePresenterImp<DashboardContract.View, DashboardIntegrator>
        implements DashboardContract.Presenter {


    @Inject
    public DashboardPresenter(DashboardIntegrator mIntegrator, CompositeDisposable compositeDisposable) {
        super(mIntegrator, compositeDisposable);
    }


    @Override
    public void loadDashboardProcess() {

        getView().hideContentLayout();

        if (getView().isNetworkConnected()) {
            getView().showLoading();

            int areaId = getIntegrator().getAreaId();
            addDisposable(getIntegrator().loadDashboardData(areaId)
                    .subscribe(this::subscribe, this::onError));

        } else {

            controlNoConnection();
        }


    }


    private void subscribe(ResponseDashboard response) {

        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();

        if (response.getStatusCode() == Constants.SUCCESS_STATUS_CODE && response.getStatus().equals(Constants.SUCCESS_STATUS)) {

            DashboardData dashboardData = response.getData();
            if (dashboardData.getCategory() != null && !dashboardData.getCategory().isEmpty() ) {
                getView().showContentLayout();
                getView().setDashboardData(dashboardData);

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
