package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Represents Meal Details Model
public class ResponseMealDetails {

    @SerializedName("data")
    @Expose
    private MealDetailsData data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private int statusCode;

    public MealDetailsData getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }




}


