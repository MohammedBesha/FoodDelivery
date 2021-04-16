package com.zetatech.foodapp.ui.login;


import com.zetatech.foodapp.ui.base.BasePresenter;
import com.zetatech.foodapp.ui.base.BaseView;

public interface LoginContract {


    interface View extends BaseView {


        boolean isValidFullNumber();

        void showErrorETPhone();

        void hideErrorETPhone();

        void showErrorETPassword();

        void hideErrorETPassword();

        void showErrorConnection();

        void showLoginFailureMessage(String msg);

        void successLogin();


    }

    interface Presenter extends BasePresenter<View, LoginIntegrator> {

        void loginProcess(String phone,int countryCodeLookupID, String password);

    }



}
