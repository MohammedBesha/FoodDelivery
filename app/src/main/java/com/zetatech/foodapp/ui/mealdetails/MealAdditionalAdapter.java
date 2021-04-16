package com.zetatech.foodapp.ui.mealdetails;



import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.MealAdditionalItem;
import com.zetatech.foodapp.databinding.ItemMealAdditionalBinding;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;


@ActivityScoped
public class MealAdditionalAdapter extends RecyclerView.Adapter<MealAdditionalAdapter.ViewHolder> {



    private List<MealAdditionalItem> mMealList;
    private String mMealCurrency;

    @Inject
    public MealAdditionalAdapter() {

        this.mMealList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMealAdditionalBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_meal_additional, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.mMealName.setText(mMealList.get(position).getName());
        String price = mMealList.get(position).getPrice() + " "+mMealCurrency+ " "+mMealList.get(position).getUnitType();
        holder.binding.mMealsPrice.setText(price);

    }


    public void setMealsList(List<MealAdditionalItem> mealList) {
        this.mMealList = mealList;
        notifyDataSetChanged();
    }


    public void setMealCurrency(String mealCurrency) {
        this.mMealCurrency = mealCurrency;
    }


    @Override
    public int getItemCount() {
        return mMealList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemMealAdditionalBinding binding;

        public ViewHolder(ItemMealAdditionalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }

}
