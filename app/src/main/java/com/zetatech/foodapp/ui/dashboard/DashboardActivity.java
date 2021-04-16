package com.zetatech.foodapp.ui.dashboard;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.tabs.TabLayout;
import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.DashboardData;
import com.zetatech.foodapp.databinding.ActivityDashboardBinding;
import com.zetatech.foodapp.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class DashboardActivity extends BaseActivity
        implements DashboardContract.View {


    @Inject
    public DashboardContract.Presenter mPresenter;
    private ActivityDashboardBinding mViewBinding;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, DashboardActivity.class);
    }


    @Override
    protected void setUpBinding() {

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
    }


    @Override
    protected void setUpView() {

        mPresenter.loadDashboardProcess();
    }


    @Override
    public void onDestroy() {

        super.onDestroy();
        mPresenter.onDetach();
        mViewBinding = null;


    }


    @Override
    protected void initPresenter() {
        mPresenter.onAttach(this);
    }


    //Set Data To Views
    @Override
    public void setDashboardData(DashboardData dashboardData) {

        mViewBinding.mTitle.setText(dashboardData.getSlogan());

        DashboardPrAdapter mDashboardPrAdapter =
                new DashboardPrAdapter(getSupportFragmentManager(), dashboardData.getCategory());

        mViewBinding.mCategoryPager.setAdapter(mDashboardPrAdapter);
        mViewBinding.mCategoryPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mViewBinding.mCategoryTab));
        mViewBinding.mCategoryTab.setupWithViewPager(mViewBinding.mCategoryPager);
    }

    //Show Content Layout
    @Override
    public void showContentLayout() {
        mViewBinding.mDashContentLay.setVisibility(View.VISIBLE);
    }

    //Hide Content Layout
    @Override
    public void hideContentLayout() {

        mViewBinding.mDashContentLay.setVisibility(View.GONE);

    }


    //Show an error if the No Connection
    @Override
    public void showNoConnectionView() {
        showViews(R.drawable.ic_no_connection, getString(R.string.ErrorNoConnection));
    }

    //Show an error if the Empty Data
    @Override
    public void showEmptyLisView() {
        showViews(R.drawable.ic_empty_list, getString(R.string.ErrorNoData));
    }

    @Override
    public void showErrorView() {
        showViews(R.drawable.ic_error, getString(R.string.ErrorConnection));
    }

    @Override
    public void showErrorConnection() {
        showError(R.string.ErrorConnection);
    }

    @Override
    public void hideHolderViews() {
        toggleEventView(false);
    }


    private void showViews(@DrawableRes int drawableId, String text) {
        mViewBinding.mEventHolder.mIvEventHolder.setImageResource(drawableId);
        mViewBinding.mEventHolder.mTvEventHolder.setText(text);
        toggleEventView(true);
    }

    private void toggleEventView(boolean show) {
        mViewBinding.mEventHolder.mLinearEventHolder.setVisibility(show ? View.VISIBLE : View.GONE);
    }


}
