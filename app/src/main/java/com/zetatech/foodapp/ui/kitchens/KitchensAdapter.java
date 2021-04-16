package com.zetatech.foodapp.ui.kitchens;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.zetatech.foodapp.R;
import com.zetatech.foodapp.data.models.Kitchen;
import com.zetatech.foodapp.data.models.MediumData;
import com.zetatech.foodapp.databinding.ItemKitchenBinding;
import com.zetatech.foodapp.utils.LoadImageGladUtil;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
public class KitchensAdapter extends RecyclerView.Adapter<KitchensAdapter.ViewHolder> {


    public interface Listener {

        void onClickItem(int kitchensId);
    }


    private List<Kitchen> mKitchensList;
    private Listener mListener;
    private Context mContext;

    @Inject
    public KitchensAdapter(@ActivityContext Context context) {
        this.mContext = context;
        this.mKitchensList = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemKitchenBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_kitchen, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.setKitchenModel(mKitchensList.get(position));


        List<MediumData> kitchenMedia = mKitchensList.get(position).getKitchenMedia();
        if (kitchenMedia != null && !kitchenMedia.isEmpty()) {
            String imgUrl = kitchenMedia.get(0).getUrls().getHrefOriginal();
            LoadImageGladUtil.loadImgRounded(mContext,holder.binding.mKitchenImg,imgUrl);
        }

        holder.itemView.setOnClickListener(v ->
                mListener.onClickItem(mKitchensList.get(position).getId()));
    }


    public void setKitchensList(List<Kitchen> kitchensList) {
        this.mKitchensList = kitchensList;
        notifyDataSetChanged();
    }


    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mKitchensList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemKitchenBinding binding;

        public ViewHolder(ItemKitchenBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }

}
