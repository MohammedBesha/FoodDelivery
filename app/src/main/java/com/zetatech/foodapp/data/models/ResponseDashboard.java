package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


//Represents Dashboard Data Model
public class ResponseDashboard {

    @SerializedName("data")
    @Expose
    private DashboardData data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private int statusCode;

    public DashboardData getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public int getStatusCode() {
        return statusCode;
    }




}


