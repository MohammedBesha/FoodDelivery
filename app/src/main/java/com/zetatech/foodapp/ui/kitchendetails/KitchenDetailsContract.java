package com.zetatech.foodapp.ui.kitchendetails;


import com.zetatech.foodapp.data.models.KitchenDetailsData;
import com.zetatech.foodapp.ui.base.BasePresenter;
import com.zetatech.foodapp.ui.base.BaseView;

public interface KitchenDetailsContract {


    interface View extends BaseView {



        void setKitchensData(KitchenDetailsData kitchensData);

        void showContentLayout();

        void hideContentLayout();

        void showNoConnectionView();

        void showEmptyLisView();

        void showErrorConnection();

        void showErrorView();

        void hideHolderViews();


    }


    interface Presenter extends BasePresenter<View, KitchenDetailsIntegrator> {

        void loadKitchensProcess(int kitchenId);

    }
}
