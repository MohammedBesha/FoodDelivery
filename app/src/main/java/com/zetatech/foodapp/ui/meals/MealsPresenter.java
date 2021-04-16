package com.zetatech.foodapp.ui.meals;



import com.zetatech.foodapp.data.models.MenuDetailsData;
import com.zetatech.foodapp.data.models.ResponseMenuDetails;
import com.zetatech.foodapp.injection.annotation.FragmentDisposable;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import com.zetatech.foodapp.utils.Constants;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class MealsPresenter extends BasePresenterImp<MealsContract.View, MealsIntegrator> implements MealsContract.Presenter {


    @Inject
    public MealsPresenter(MealsIntegrator mIntegrator, @FragmentDisposable CompositeDisposable compositeDisposable) {
        super(mIntegrator, compositeDisposable);
    }




    @Override
    public void loadMenuDetailsProcess(int menuId ) {

        //getView().hideContentLayout();

        if (getView().isNetworkConnected()) {
            getView().showLoading();
            addDisposable(getIntegrator().loadMenuDetails(menuId)
                    .subscribe(this::subscribe, this::onError));
        } else {

            controlNoConnection();
        }


    }



    private void subscribe(ResponseMenuDetails response) {


        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();


        if (response.getStatusCode() == Constants.SUCCESS_STATUS_CODE && response.getStatus().equals(Constants.SUCCESS_STATUS)) {

           MenuDetailsData data = response.getData();


            if (data != null && !data.getMeals().isEmpty()) {

                getView().showContentLayout();
                getView().setMealsList(data.getMeals());



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
