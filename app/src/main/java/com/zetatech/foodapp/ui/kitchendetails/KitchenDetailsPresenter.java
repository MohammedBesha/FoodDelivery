package com.zetatech.foodapp.ui.kitchendetails;


import com.zetatech.foodapp.data.models.KitchenDetailsData;
import com.zetatech.foodapp.data.models.ResponseKitchenDetails;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import com.zetatech.foodapp.utils.Constants;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class KitchenDetailsPresenter extends BasePresenterImp<KitchenDetailsContract.View, KitchenDetailsIntegrator>
        implements KitchenDetailsContract.Presenter {


    @Inject
    public KitchenDetailsPresenter(KitchenDetailsIntegrator mIntegrator, CompositeDisposable compositeDisposable) {
        super(mIntegrator, compositeDisposable);
    }


    @Override
    public void loadKitchensProcess(int kitchenId) {

        getView().hideContentLayout();

        if (getView().isNetworkConnected()) {
            getView().showLoading();

            addDisposable(getIntegrator().loadKitchensData(kitchenId)
                    .subscribe(this::subscribe, this::onError));

        } else {

            controlNoConnection();
        }


    }


    private void subscribe(ResponseKitchenDetails response) {

        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();

        if (response.getStatusCode() == Constants.SUCCESS_STATUS_CODE  && response.getStatus().equals(Constants.SUCCESS_STATUS)) {

            KitchenDetailsData data = response.getData();

            if (!data.getName().isEmpty() && data.getMenus() != null ) {
                getView().showContentLayout();
                getView().setKitchensData(data);

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
