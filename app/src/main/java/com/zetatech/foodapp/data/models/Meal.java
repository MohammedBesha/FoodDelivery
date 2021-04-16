package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meal {
    @SerializedName("is_available")
    @Expose
    private boolean isAvailable;
    @SerializedName("rating_count")
    @Expose
    private long ratingCount;
    @SerializedName("meal_media")
    @Expose
    private List<MediumData> mealMedia = null;
    @SerializedName("menu_id")
    @Expose
    private long menuId;
    @SerializedName("price")
    @Expose
    private float price;
    @SerializedName("meal_currency")
    @Expose
    private String mealCurrency;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quantity_for_the_day")
    @Expose
    private long quantityForTheDay;
    @SerializedName("has_delivery")
    @Expose
    private boolean hasDelivery;

    public boolean isIsAvailable() {
        return isAvailable;
    }



    public long getRatingCount() {
        return ratingCount;
    }


    public List<MediumData> getMealMedia() {
        return mealMedia;
    }



    public long getMenuId() {
        return menuId;
    }

    public float getPrice() {
        return price;
    }



    public String getMealCurrency() {
        return mealCurrency;
    }



    public int getId() {
        return id;
    }



    public float getRating() {
        return rating;
    }



    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }


    public long getQuantityForTheDay() {
        return quantityForTheDay;
    }



    public boolean isHasDelivery() {
        return hasDelivery;
    }



}
