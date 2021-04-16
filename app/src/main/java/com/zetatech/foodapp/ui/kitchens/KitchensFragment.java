package com.zetatech.foodapp.ui.kitchens;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.Kitchen;
import com.zetatech.foodapp.databinding.FragKitchensBinding;
import com.zetatech.foodapp.ui.base.BaseFragment;
import com.zetatech.foodapp.ui.kitchendetails.KitchenDetailsActivity;

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class KitchensFragment extends BaseFragment
        implements KitchensContract.View, KitchensAdapter.Listener {


    //arg key
    public static final String ARG_KITCHENS_LIST = "ArgKitchensList";


    @Inject
    KitchensAdapter mKitchensAdapter;

    @Inject
    public KitchensContract.Presenter mPresenter;

    private FragKitchensBinding mViewBinding;
    private List<Kitchen> mKitchensList;


    public static KitchensFragment newInstance(List<Kitchen> kitchensList) {
        KitchensFragment fragment = new KitchensFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_KITCHENS_LIST, Parcels.wrap(kitchensList));
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            mKitchensList = Parcels.unwrap(getArguments().getParcelable(ARG_KITCHENS_LIST));
    }


    @Nullable
    @Override
    public View onCreateView(
            @NotNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(inflater, R.layout.frag_kitchens, container, false);
        initPresenter();
        setUpView();

        return mViewBinding.getRoot();
    }




    @Override
    public void onDestroy() {

        super.onDestroy();
        mPresenter.onDetach();

    }


    @Override
    protected void setUpView() {

        setupKitchensRecycler();
    }


    @Override
    protected void initPresenter() {
        mPresenter.onAttach(this);
    }

    @Override
    protected void lazyLoad() {

    }


    // Configure the RecyclerView and initialize adapter
    private void setupKitchensRecycler() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseActivity());
        mViewBinding.mKitchensRec.setLayoutManager(layoutManager);
        mViewBinding.mKitchensRec.setAdapter(mKitchensAdapter);

        if (mKitchensList != null && !mKitchensList.isEmpty()) {
            mKitchensAdapter.setKitchensList(mKitchensList);
            mKitchensAdapter.setListener(this);
        }
    }


    @Override
    public void onClickItem(int kitchensId) {
        Intent intent = KitchenDetailsActivity.getStartIntent(getBaseActivity(), kitchensId);
        startActivity(intent);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
