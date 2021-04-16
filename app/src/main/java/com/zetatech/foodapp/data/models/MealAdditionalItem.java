package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealAdditionalItem {


    @SerializedName("is_available")
    @Expose
    private boolean isAvailable;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("qty")
    @Expose
    private int qty;
    @SerializedName("unit_id")
    @Expose
    private int unitId;
    @SerializedName("unit_type")
    @Expose
    private String unitType;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("quantity_for_the_day")
    @Expose
    private int quantityForTheDay;
    @SerializedName("available_count_for_the_day")
    @Expose
    private int availableCountForTheDay;

    public boolean isIsAvailable() {
        return isAvailable;
    }


    public String getName() {
        return name;
    }



    public int getPrice() {
        return price;
    }


    public int getQty() {
        return qty;
    }


    public int getUnitId() {
        return unitId;
    }

    public String getUnitType() {
        return unitType;
    }



    public int getId() {
        return id;
    }



    public int getQuantityForTheDay() {
        return quantityForTheDay;
    }



    public int getAvailableCountForTheDay() {
        return availableCountForTheDay;
    }


}
