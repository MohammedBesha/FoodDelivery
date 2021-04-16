package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Parcel
public class Kitchen {

    @SerializedName("is_available")
    @Expose
    boolean isAvailable;
    @SerializedName("rating_count")
    @Expose
    int ratingCount;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("original_description")
    @Expose
    String originalDescription;
    @SerializedName("short_description")
    @Expose
    String shortDescription;
    @SerializedName("availability_time")
    @Expose
    String availabilityTime;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("kitchen_currency")
    @Expose
    String kitchenCurrency;

    @SerializedName("kitchen_media")
    @Expose
    List<MediumData> kitchenMedia;

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("rating")
    @Expose
    float rating;
    @SerializedName("new_kitchen_notification_sent")
    @Expose
    boolean newKitchenNotificationSent;

    public boolean isIsAvailable() {
        return isAvailable;
    }


    public List<MediumData> getKitchenMedia() {
        return kitchenMedia;
    }

    public Object getRatingCount() {
        return ratingCount;
    }


    public String getName() {
        return name;
    }


    public String getOriginalDescription() {
        return originalDescription;
    }


    public Object getShortDescription() {
        return shortDescription;
    }


    public String getAvailabilityTime() {
        return availabilityTime;
    }


    public String getDescription() {
        return description;
    }


    public String getKitchenCurrency() {
        return kitchenCurrency;
    }


    public int getId() {
        return id;
    }


    public String getRating() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatter = (DecimalFormat) nf;
        formatter.applyPattern("#.#");

        return formatter.format(rating);
    }

    public boolean isNewKitchenNotificationSent() {
        return newKitchenNotificationSent;
    }



}


