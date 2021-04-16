package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

////Represents Login Data Model
public class ResponseLogin {

    @SerializedName("data")
    @Expose
    private LoginData data;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private long statusCode;

    public LoginData getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public long getStatusCode() {
        return statusCode;
    }


}


