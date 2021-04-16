package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ImagesUrl {

    @SerializedName("href_small")
    @Expose
    String hrefSmall;
    @SerializedName("href_big")
    @Expose
    String hrefBig;
    @SerializedName("href_original")
    @Expose
    String hrefOriginal;

    public String getHrefSmall() {
        return hrefSmall;
    }


    public String getHrefBig() {
        return hrefBig;
    }


    public String getHrefOriginal() {
        return hrefOriginal;
    }


}
