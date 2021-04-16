package com.zetatech.foodapp.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import androidx.fragment.app.Fragment;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.utils.NetworkUtil;



public abstract class BaseFragment extends Fragment implements BaseView {


    private BaseActivity mActivity;
    private Context mContext;

    /**
     * Fragment Is the current state visible
     */
    protected boolean isVisible;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        setUpView();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        this.mActivity = (BaseActivity) requireActivity();

    }

    @Override
    public void onResume() {
        super.onResume();
        isVisible = true;
        onVisible();

    }


    @Override
    public void onPause() {
        super.onPause();
        isVisible = false;
        onInvisible();


    }


    //Represents setup Fragment Views
    protected abstract void setUpView();

    //Represents initialize Presenter
    protected abstract void initPresenter();


    // The function is called if the fragment visible .
    // Used to load the data that the fragment needs.
    protected void onVisible() {
        lazyLoad();
    }

    // The function is called if the fragment invisible.
    protected void onInvisible() {

    }

    //Delayed loading
    //Subclasses must override this method
    protected abstract void lazyLoad();


    @Override
    public void showLoading() {

        mActivity.showLoading();
    }

    @Override
    public void hideLoading() {

        mActivity.hideLoading();

    }


    protected void showError(String message) {
        if (mActivity != null) {
            mActivity.showError(message);
        }
    }

    protected void showError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showError(resId);
        }
    }

    protected void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    protected void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }

    @Override
    public void onDetach() {
        super.onDetach();

        mActivity = null;
        mContext = null;
    }


    protected Activity getBaseActivity() {
        return mActivity;
    }


    @Override
    public boolean isNetworkConnected() {
        return NetworkUtil.isNetworkConnected(mActivity);
    }

    @Override
    public void showNoConnection() {
        showError(R.string.ErrorNoConnection);

    }


}
