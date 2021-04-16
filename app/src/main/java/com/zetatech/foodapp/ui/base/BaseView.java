package com.zetatech.foodapp.ui.base;


public interface BaseView {


    void showLoading();

    void hideLoading();

    boolean isNetworkConnected();

    void showNoConnection();


}