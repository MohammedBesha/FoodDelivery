package com.zetatech.foodapp.ui.kitchendetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.tabs.TabLayout;
import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.KitchenDetailsData;
import com.zetatech.foodapp.data.models.KitchenMenu;
import com.zetatech.foodapp.data.models.MediumData;
import com.zetatech.foodapp.databinding.ActivityKitchenDetailsBinding;
import com.zetatech.foodapp.ui.base.BaseActivity;
import com.zetatech.foodapp.utils.LoadImageGladUtil;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class KitchenDetailsActivity extends BaseActivity
        implements KitchenDetailsContract.View {


    private static final String KEY_KITCHEN_ID = "keyKitchenID";

    @Inject
    public KitchenDetailsContract.Presenter mPresenter;
    private ActivityKitchenDetailsBinding mViewBinding;

    private int mKitchenId;

    public static Intent getStartIntent(Context context, int kitchenId) {

        Intent intent = new Intent(context, KitchenDetailsActivity.class);
        intent.putExtra(KEY_KITCHEN_ID, kitchenId);
        return intent;

    }


    @Override
    protected void setUpBinding() {

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_kitchen_details);
    }


    @Override
    protected void setUpView() {

        receivedDataFromIntent();
        mViewBinding.mBack.setOnClickListener(view -> onBackPressed());
        mPresenter.loadKitchensProcess(mKitchenId);

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


    private void receivedDataFromIntent() {

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        if (data != null) {
            mKitchenId = data.getInt(KEY_KITCHEN_ID);
        }

    }


    @Override
    public void setKitchensData(KitchenDetailsData kitchensData) {

        mViewBinding.mKitchenName.setText(kitchensData.getName());
        mViewBinding.mKitchenDescription.setText(kitchensData.getDescription());

        String rate = kitchensData.getRating() + "(" + kitchensData.getRatingCount() + getString(R.string.rate) + ")";
        mViewBinding.mRate.setText(rate);

        if (kitchensData.isHasDelivery()) {
            mViewBinding.mDelivery.setText(getString(R.string.deliveryAvailable));
        } else {
            mViewBinding.mDelivery.setText(getString(R.string.deliveryNotAvailable));
        }

        List<MediumData> kitchenMedia = kitchensData.getKitchenMedia();
        if (kitchenMedia != null && !kitchenMedia.isEmpty()) {
            String imgUrl = kitchenMedia.get(0).getUrls().getHrefOriginal();
            LoadImageGladUtil.loadImgRounded(this, mViewBinding.mKitchenImg, imgUrl);
        }

        setupMenusPager(kitchensData.getMenus());
    }

    private void setupMenusPager(List<KitchenMenu> menus) {


        KitchenDetailsPrAdapter mPagerAdapter =
                new KitchenDetailsPrAdapter(getSupportFragmentManager(), menus);
        mViewBinding.mMenusPager.setAdapter(mPagerAdapter);
        mViewBinding.mMenusPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mViewBinding.mMenusTab));
        mViewBinding.mMenusTab.setupWithViewPager(mViewBinding.mMenusPager);

    }

    @Override
    public void showContentLayout() {
        mViewBinding.mKitchenContentLay.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentLayout() {

        mViewBinding.mKitchenContentLay.setVisibility(View.GONE);

    }


    @Override
    public void showNoConnectionView() {
        showViews(R.drawable.ic_no_connection, getString(R.string.ErrorNoConnection));
    }


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
