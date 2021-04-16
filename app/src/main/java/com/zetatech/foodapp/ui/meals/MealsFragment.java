package com.zetatech.foodapp.ui.meals;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.Meal;
import com.zetatech.foodapp.databinding.FragMealsBinding;
import com.zetatech.foodapp.ui.base.BaseFragment;
import com.zetatech.foodapp.ui.mealdetails.MealDetailsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MealsFragment extends BaseFragment
        implements MealsContract.View, MealsAdapter.Listener {


    //arg key
    public static final String ARG_MENU_ID = "ArgMenuId";


    @Inject
    MealsAdapter mMealsAdapter;
    @Inject
    public MealsContract.Presenter mPresenter;
    private FragMealsBinding mViewBinding;
    private int mMenuId;

    // Flag bit, the flag has been initialized.
    private boolean isPrepared;
    //  Has it been loaded once, and the second time you stop requesting data
    private boolean mHasLoadedOnce;


    public static MealsFragment newInstance(int menuId) {
        MealsFragment fragment = new MealsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MENU_ID, menuId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            mMenuId = getArguments().getInt(ARG_MENU_ID);
    }


    @Nullable
    @Override
    public View onCreateView(
            @NotNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(inflater, R.layout.frag_meals, container, false);
        isPrepared = true;
        return mViewBinding.getRoot();
    }


    @Override
    public void onDestroyView() {


        mPresenter.onDetach();
        super.onDestroyView();

    }


    @Override
    protected void setUpView() {
        setupMealsRecycler();
    }


    @Override
    protected void initPresenter() {
        mPresenter.onAttach(this);
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        mPresenter.loadMenuDetailsProcess(mMenuId);

    }


    private void setupMealsRecycler() {
        // Configure the RecyclerView and initialize adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseActivity());
        mViewBinding.mMealsRec.setLayoutManager(layoutManager);
        mViewBinding.mMealsRec.setHasFixedSize(true);
        mViewBinding.mMealsRec.setAdapter(mMealsAdapter);
        mMealsAdapter.setListener(this);
    }


    @Override
    public void setMealsList(List<Meal> mealsList) {
        mHasLoadedOnce = true;
        mMealsAdapter.setMealsList(mealsList);
    }


    @Override
    public void showLoading() {
        mViewBinding.mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mViewBinding.mLoading.setVisibility(View.GONE);
    }

    @Override
    public void showContentLayout() {

        mViewBinding.mMealsRec.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentLayout() {

        mViewBinding.mMealsRec.setVisibility(View.GONE);

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


    @Override
    public void onClickItem(int mealID) {

        Intent intent = MealDetailsActivity.getStartIntent(getBaseActivity(), mealID);
        startActivity(intent);


    }


}
