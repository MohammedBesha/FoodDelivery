package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class KitchenDetailsData {

    @SerializedName("is_available")
    @Expose
    private boolean isAvailable;
    @SerializedName("rating_count")
    @Expose
    private long ratingCount;
    @SerializedName("approval_status")
    @Expose
    private String approvalStatus;
    @SerializedName("original_description")
    @Expose
    private String originalDescription;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("kitchen_delivery_options")
    @Expose
    private List<Object> kitchenDeliveryOptions = null;
    @SerializedName("short_description")
    @Expose
    private Object shortDescription;
    @SerializedName("availability_time")
    @Expose
    private String availabilityTime;
    @SerializedName("menus")
    @Expose
    private List<KitchenMenu> menus = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("kitchen_currency")
    @Expose
    private String kitchenCurrency;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("kitchen_media")
    @Expose
    private List<MediumData> kitchenMedia = null;
    @SerializedName("rating")
    @Expose
    private double rating;
    @SerializedName("new_kitchen_notification_sent")
    @Expose
    private boolean newKitchenNotificationSent;
    @SerializedName("has_delivery")
    @Expose
    private boolean hasDelivery;
    @SerializedName("is_favorite")
    @Expose
    private boolean isFavorite;
    @SerializedName("is_notification_enabled")
    @Expose
    private boolean isNotificationEnabled;

    public boolean isIsAvailable() {
        return isAvailable;
    }


    public long getRatingCount() {
        return ratingCount;
    }


    public String getApprovalStatus() {
        return approvalStatus;
    }



    public String getOriginalDescription() {
        return originalDescription;
    }



    public long getId() {
        return id;
    }


    public List<Object> getKitchenDeliveryOptions() {
        return kitchenDeliveryOptions;
    }


    public Object getShortDescription() {
        return shortDescription;
    }



    public String getAvailabilityTime() {
        return availabilityTime;
    }


    public List<KitchenMenu> getMenus() {
        return menus;
    }



    public String getDescription() {
        return description;
    }



    public String getKitchenCurrency() {
        return kitchenCurrency;
    }



    public String getName() {
        return name;
    }



    public List<MediumData> getKitchenMedia() {
        return kitchenMedia;
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



    public boolean isHasDelivery() {
        return hasDelivery;
    }


    public boolean isIsFavorite() {
        return isFavorite;
    }



    public boolean isIsNotificationEnabled() {
        return isNotificationEnabled;
    }



}