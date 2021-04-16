package com.zetatech.foodapp.ui.login;


import com.zetatech.foodapp.data.models.ResponseLogin;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import com.zetatech.foodapp.utils.Constants;
import com.zetatech.foodapp.utils.ValidationText;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class LoginPresenter extends BasePresenterImp<LoginContract.View, LoginIntegrator>
        implements LoginContract.Presenter {


    @Inject
    public LoginPresenter(LoginIntegrator integrator, CompositeDisposable compositeDisposable) {
        super(integrator, compositeDisposable);
    }

    @Override
    public void loginProcess(String phone, int countryCodeLookupID, String password) {

        boolean valid = validationInputData(password);
        if (valid) {

            if (getView().isNetworkConnected()) {
                getView().showLoading();
                addDisposable(getIntegrator().login(phone, countryCodeLookupID, password)
                        .subscribe(this::subscribe, this::onError));
            } else {

                getView().showNoConnection();
            }
        }
    }


    private void subscribe(ResponseLogin response) {

        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();

        if (response != null) {

            if (response.getStatusCode() == Constants.SUCCESS_STATUS_CODE  && response.getStatus().equals(Constants.SUCCESS_STATUS)) {

                if (response.getData() != null)
                    getIntegrator().saveUserLogin(response.getData());
                getView().successLogin();

            } else {
                getView().showLoginFailureMessage(response.getStatus());
            }

        } else {

            getView().showErrorConnection();
        }

    }

    private void onError(Throwable throwable) {

        if (!isViewAttached()) {
            return;
        }
        getView().hideLoading();
        getView().showErrorConnection();

    }

    //validation the input login
    private boolean validationInputData(String password) {

        boolean valid = true;


        if (!getView().isValidFullNumber()) {
            valid = false;
            //show Error on EditText Username
            getView().showErrorETPhone();
        } else {
            getView().hideErrorETPhone();
        }


        if (!ValidationText.valid(password, ValidationText.PASSWORD_PATTERN)) {
            valid = false;
            //show Error on EditText Password
            getView().showErrorETPassword();
        } else {

            getView().hideErrorETPassword();
        }

        return valid;
    }


}
