package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardData {


    @SerializedName("category")
    @Expose
    private List<KitchenCategory> category = null;
    @SerializedName("slogan")
    @Expose
    private String slogan;



    public List<KitchenCategory> getCategory() {
        return category;
    }


    public String getSlogan() {
        return slogan;
    }


}
