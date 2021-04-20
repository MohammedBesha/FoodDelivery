package com.zetatech.foodapp.ui.login;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.databinding.ActivityLoginBinding;
import com.zetatech.foodapp.ui.base.BaseActivity;
import com.zetatech.foodapp.ui.dashboard.DashboardActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends BaseActivity implements LoginContract.View {


    @Inject
    LoginContract.Presenter mPresenter;
    private ActivityLoginBinding mViewBinding;

    private boolean mLoginEnable = false;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }


    @Override
    public void onDestroy() {
        if (mPresenter != null)
            mPresenter.onDetach();

        mViewBinding = null;

        super.onDestroy();

    }


    @Override
    protected void setUpBinding() {

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

    }


    @Override
    protected void setUpView() {


        // pass phone Number editText to countryPicker for  use functions like
        // setFullNumber() and getFullNumber().
        mViewBinding.mSignInCCP.registerCarrierNumberEditText(mViewBinding.mSignInPhone);

        mViewBinding.mSignInBtn.setOnClickListener(view -> {

            if (mLoginEnable) {
                mPresenter.loginProcess(getPhone(), 224, getPassword());
            } else {

                mViewBinding.mSignInPhoneLay.setVisibility(View.VISIBLE);
                mViewBinding.mSignInPassword.setVisibility(View.VISIBLE);
                mViewBinding.mForgetPassword.setVisibility(View.VISIBLE);
                mLoginEnable = true;
            }
        });
    }


    @Override
    protected void initPresenter() {

        mPresenter.onAttach(this);
    }


    private String getPhone() {
        //   return mViewBinding.mSignInCCP.getFullNumber().trim();
        return mViewBinding.mSignInPhone.getText().toString().trim();
    }

    private String getPassword() {

        return mViewBinding.mSignInPassword.getText().toString().trim();
    }

    //Show an error if the phone number is written incorrectly
    @Override
    public void showErrorETPhone() {

        mViewBinding.mSignInPhone.setError(getString(R.string.ErrorWritingPhone));
    }

    //Hide an error if the phone number is written correctly
    @Override
    public void hideErrorETPhone() {

        mViewBinding.mSignInPhone.setError(null);
    }

    //Show an error if the password number is written incorrectly
    @Override
    public void showErrorETPassword() {

        mViewBinding.mSignInPassword.setError(getString(R.string.ErrorWritingPassword));
    }

    //Hide an error if the phone number is written correctly
    @Override
    public void hideErrorETPassword() {
        mViewBinding.mSignInPassword.setError(null);
    }


    //Show an error if the connection fails
    @Override
    public void showErrorConnection() {

        showError(R.string.ErrorSignInConnection);

    }

    //Show an message if the login failure
    @Override
    public void showLoginFailureMessage(String msg) {

        showMessage(msg);
    }


    @Override
    public void successLogin() {
        showMessage("Success Login!");
        openHomePage();

    }


    //validation the phone number
    @Override
    public boolean isValidFullNumber() {

        boolean valid = true;

        if (!mViewBinding.mSignInCCP.isValidFullNumber()) {
            valid = false;
        }

        return valid;
    }

    private void openHomePage() {

        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();


    }


}



