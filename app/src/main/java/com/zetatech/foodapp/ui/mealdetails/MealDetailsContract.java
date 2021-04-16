package com.zetatech.foodapp.ui.mealdetails;


import com.zetatech.foodapp.data.models.MealDetailsData;
import com.zetatech.foodapp.ui.base.BasePresenter;
import com.zetatech.foodapp.ui.base.BaseView;

public interface MealDetailsContract {


    interface View extends BaseView {

        void setMealDetailsData(MealDetailsData mealDetailsData);

        void showContentLayout();

        void hideContentLayout();

        void showNoConnectionView();

        void showEmptyLisView();

        void showErrorConnection();

        void showErrorView();

        void hideHolderViews();


    }


    interface Presenter extends BasePresenter<View, MealDetailsIntegrator> {

        void loadMealDetailsProcess(int mealId);

    }
}
