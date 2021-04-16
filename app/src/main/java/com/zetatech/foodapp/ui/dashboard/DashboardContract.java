package com.zetatech.foodapp.ui.dashboard;


import com.zetatech.foodapp.data.models.DashboardData;
import com.zetatech.foodapp.data.models.ResponseDashboard;
import com.zetatech.foodapp.ui.base.BasePresenter;
import com.zetatech.foodapp.ui.base.BaseView;

import java.util.List;

public interface DashboardContract {


    interface View extends BaseView {



        void setDashboardData(DashboardData dashboardData);

        void showContentLayout();

        void hideContentLayout();

        void showNoConnectionView();

        void showEmptyLisView();

        void showErrorConnection();

        void showErrorView();

        void hideHolderViews();


    }


    interface Presenter extends BasePresenter<View, DashboardIntegrator> {

        void loadDashboardProcess( );

    }
}
