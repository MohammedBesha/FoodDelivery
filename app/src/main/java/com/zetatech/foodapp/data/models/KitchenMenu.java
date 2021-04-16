package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KitchenMenu {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("kitchen_id")
    @Expose
    private long kitchenId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("food_category_id")
    @Expose
    private long foodCategoryId;

    public String getName() {
        return name;
    }



    public long getKitchenId() {
        return kitchenId;
    }



    public String getDescription() {
        return description;
    }



    public int getId() {
        return id;
    }



    public long getFoodCategoryId() {
        return foodCategoryId;
    }



}
