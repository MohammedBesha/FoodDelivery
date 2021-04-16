package com.zetatech.foodapp.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import com.zetatech.foodapp.R;
import com.zetatech.foodapp.utils.DialogUtil;
import com.zetatech.foodapp.utils.NetworkUtil;

import es.dmoral.toasty.Toasty;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {


    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpBinding();
        initPresenter();
        setUpView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProgressDialog = null;
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    //Represents setup  Views
    protected abstract void setUpView();

    //Represents setup ViewBinding
    protected abstract void setUpBinding();

    //Represents initialize Presenter
    protected abstract void initPresenter();



    @Override
    public void showLoading() {
        hideLoading();
        if (mProgressDialog == null)
            mProgressDialog = DialogUtil.showLoadingDialog(this);
        else
            mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    protected void showError(String message) {
        if (message != null) {
            Toasty.error(this, message).show();

        } else {
            Toasty.error(this, getString(R.string.error_reload)).show();

        }
    }

    protected void showError(@StringRes int resId) {
        showError(getString(resId));
    }

    protected void showMessage(String message) {
        if (message != null) {
            Toasty.normal(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toasty.normal(this,  getString(R.string.error_reload), Toast.LENGTH_SHORT).show();
        }
    }

    protected void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }




    @Override
    public void showNoConnection() {
       showError(R.string.ErrorNoConnection);

    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtil.isNetworkConnected(getApplicationContext());
    }


}
