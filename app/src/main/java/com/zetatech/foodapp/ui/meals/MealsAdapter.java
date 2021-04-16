package com.zetatech.foodapp.ui.meals;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.Meal;
import com.zetatech.foodapp.data.models.MediumData;
import com.zetatech.foodapp.databinding.ItemMealsBinding;
import com.zetatech.foodapp.utils.LoadImageGladUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {


    public interface Listener {

        void onClickItem(int mealID);
    }


    private List<Meal> mMealList;
    private Listener mListener;
    private Context mContext;

    @Inject
    public MealsAdapter(@ActivityContext Context context) {
        this.mContext = context;
        this.mMealList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMealsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_meals, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.setMealModel(mMealList.get(position));

        List<MediumData> mediumData = mMealList.get(position).getMealMedia();
        if (mediumData != null && !mediumData.isEmpty()) {
            String imgUrl = mediumData.get(0).getUrls().getHrefOriginal();
            LoadImageGladUtil.loadImgRounded(mContext,holder.binding.mKitchenImg,imgUrl);
        }

        holder.itemView.setOnClickListener(v ->
                mListener.onClickItem(mMealList.get(position).getId()));
    }


    public void setMealsList(List<Meal> mealList) {
        this.mMealList = mealList;
        notifyDataSetChanged();
    }


    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mMealList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemMealsBinding binding;

        public ViewHolder(ItemMealsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }

}
