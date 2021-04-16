package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuDetailsData {

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
    private long id;
    @SerializedName("food_category_id")
    @Expose
    private long foodCategoryId;
    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;

    public String getName() {
        return name;
    }



    public long getKitchenId() {
        return kitchenId;
    }



    public String getDescription() {
        return description;
    }


    public long getId() {
        return id;
    }



    public long getFoodCategoryId() {
        return foodCategoryId;
    }



    public List<Meal> getMeals() {
        return meals;
    }



}