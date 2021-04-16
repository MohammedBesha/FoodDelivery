package com.zetatech.foodapp.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.zetatech.foodapp.R;

public class LoadImageGladUtil {


    //Represents load image by Glide .
    @BindingAdapter("loadImgRound")
    public static void loadImgRounded(Context context, ImageView imageView , String imageUrl)
    {
        //Load image
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .transform(new CenterCrop(),new RoundedCorners(10))
                .placeholder(R.drawable.ic_restaurant)
                .into(imageView);
    }



}
