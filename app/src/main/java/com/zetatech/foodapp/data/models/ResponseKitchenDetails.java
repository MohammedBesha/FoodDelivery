package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Represents Kitchen Details Model
public class ResponseKitchenDetails {

    @SerializedName("data")
    @Expose
    private KitchenDetailsData data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private long statusCode;

    public KitchenDetailsData getData() {
        return data;
    }



    public String getStatus() {
        return status;
    }



    public long getStatusCode() {
        return statusCode;
    }


}




