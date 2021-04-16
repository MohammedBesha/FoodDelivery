package com.zetatech.foodapp.ui.meals;


import com.zetatech.foodapp.data.models.Meal;
import com.zetatech.foodapp.ui.base.BasePresenter;
import com.zetatech.foodapp.ui.base.BaseView;

import java.util.List;

public interface MealsContract {


    interface View extends BaseView {


        void setMealsList(List<Meal> mealsList);

        void showContentLayout();

        void hideContentLayout();

        void showNoConnectionView();

        void showEmptyLisView();

        void showErrorConnection();

        void showErrorView();

        void hideHolderViews();

    }


    interface Presenter extends BasePresenter<View, MealsIntegrator> {


        void loadMenuDetailsProcess(int menuId );;


    }
}
