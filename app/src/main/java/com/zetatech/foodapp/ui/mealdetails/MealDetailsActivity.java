package com.zetatech.foodapp.ui.mealdetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.MealDetailsData;
import com.zetatech.foodapp.data.models.MediumData;
import com.zetatech.foodapp.databinding.ActivityMealDetailsBinding;
import com.zetatech.foodapp.ui.base.BaseActivity;
import com.zetatech.foodapp.utils.LoadImageGladUtil;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MealDetailsActivity extends BaseActivity
        implements MealDetailsContract.View {


    private static final String KEY_MEAL_ID = "keyMealID";

    @Inject
    public MealDetailsContract.Presenter mPresenter;
    @Inject
    MealAdditionalAdapter mMealAdditionalAdapter;

    private ActivityMealDetailsBinding mViewBinding;

    private int mMealId;

    public static Intent getStartIntent(Context context, int mealID) {

        Intent intent = new Intent(context, MealDetailsActivity.class);
        intent.putExtra(KEY_MEAL_ID, mealID);
        return intent;

    }


    @Override
    protected void setUpBinding() {

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_meal_details);
    }


    @Override
    protected void setUpView() {

        receivedDataFromIntent();
        setupBackButton();
        setupMealAdditionalRecycler();
        mPresenter.loadMealDetailsProcess(mMealId);

        mViewBinding.mPlusQty.setOnClickListener(view -> {
            increaseQuantity();
        });

        mViewBinding.mMinusQty.setOnClickListener(view -> {
            decreaseQuantity();
        });

    }

    private void setupBackButton() {
        setSupportActionBar(mViewBinding.mMealToolbar);
        mViewBinding.mMealToolbar.setNavigationOnClickListener(view -> onBackPressed());

    }


    private void increaseQuantity() {

        int quantity = Integer.parseInt(mViewBinding.mQuantity.getText().toString());
        quantity++;
        mViewBinding.mQuantity.setText(String.valueOf(quantity));
    }

    private void decreaseQuantity() {

        int quantity = Integer.parseInt(mViewBinding.mQuantity.getText().toString());
        if (quantity > 1) {
            quantity--;
            mViewBinding.mQuantity.setText(String.valueOf(quantity));
        }
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
            mMealId = data.getInt(KEY_MEAL_ID);
        }

    }

    private void setupMealAdditionalRecycler() {
        // Configure the RecyclerView and initialize adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mViewBinding.mRvMealAdditional.setLayoutManager(layoutManager);
       mViewBinding.mRvMealAdditional.setAdapter(mMealAdditionalAdapter);

    }

    @Override
    public void setMealDetailsData(MealDetailsData mealDetailsData) {

        mViewBinding.setMealModel(mealDetailsData);

        //load image
        List<MediumData> mediumData = mealDetailsData.getMealMedia();
        if (mediumData != null && !mediumData.isEmpty()) {
            String imgUrl = mediumData.get(0).getUrls().getHrefOriginal();
            LoadImageGladUtil.loadImgRounded(this, mViewBinding.mMealImg, imgUrl);
        }

        if (mealDetailsData.isHasDelivery())
            mViewBinding.mMealDelivery.setText(getString(R.string.deliveryAvailable));
        else
            mViewBinding.mMealDelivery.setText(getString(R.string.deliveryNotAvailable));


        String rate = mealDetailsData.getRating() + "(" + mealDetailsData.getRatingCount() + getString(R.string.rate) + ")";
        mViewBinding.mMealRate.setText(rate);

        mMealAdditionalAdapter.setMealCurrency(mealDetailsData.getMealCurrency());
        mMealAdditionalAdapter.setMealsList(mealDetailsData.getMealAdditionalItems());
    }


    @Override
    public void showContentLayout() {
        mViewBinding.mMealContentLay.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentLayout() {

        mViewBinding.mMealContentLay.setVisibility(View.GONE);

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
