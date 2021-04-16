package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KitchenCategory {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("kitchens")
    @Expose
    private List<Kitchen> kitchens = null;

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    public List<Kitchen> getKitchens() {
        return kitchens;
    }


}