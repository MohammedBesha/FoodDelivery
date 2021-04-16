package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MediumData {

    @SerializedName("urls")
    @Expose
    ImagesUrl urls;
    @SerializedName("id")
    @Expose
    int id;

    public ImagesUrl getUrls() {
        return urls;
    }


    public int getId() {
        return id;
    }

}
