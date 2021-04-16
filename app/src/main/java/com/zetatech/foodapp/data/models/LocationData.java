package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationData {
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("area_id")
    @Expose
    private long areaId;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("area_name")
    @Expose
    private String areaName;

    public String getCityName() {
        return cityName;
    }


    public double getLongitude() {
        return longitude;
    }


    public long getAreaId() {
        return areaId;
    }


    public double getLatitude() {
        return latitude;
    }


    public String getAreaName() {
        return areaName;
    }


}
