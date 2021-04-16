package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Represents Menu Details Model
public class ResponseMenuDetails {

    @SerializedName("data")
    @Expose
    private MenuDetailsData data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private long statusCode;

    public MenuDetailsData getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }



    public long getStatusCode() {
        return statusCode;
    }



}

