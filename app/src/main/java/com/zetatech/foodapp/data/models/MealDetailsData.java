package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class MealDetailsData {


    @SerializedName("additional_info_map")
    @Expose
    private Object additionalInfoMap;
    @SerializedName("is_available")
    @Expose
    private boolean isAvailable;
    @SerializedName("rating_count")
    @Expose
    private int ratingCount;
    @SerializedName("availability_message")
    @Expose
    private String availabilityMessage;
    @SerializedName("additional_notes")
    @Expose
    private Object additionalNotes;
    @SerializedName("meal_media")
    @Expose
    private List<MediumData> mealMedia = null;
    @SerializedName("qty")
    @Expose
    private int qty;
    @SerializedName("meal_unit")
    @Expose
    private String mealUnit;
    @SerializedName("availability_time")
    @Expose
    private String availabilityTime;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("meal_additional_items")
    @Expose
    private List<MealAdditionalItem> mealAdditionalItems = null;
    @SerializedName("meal_delivery_options")
    @Expose
    private List<Long> mealDeliveryOptions = null;
    @SerializedName("menu_id")
    @Expose
    private int menuId;
    @SerializedName("meal_currency")
    @Expose
    private String mealCurrency;
    @SerializedName("unit_id")
    @Expose
    private int unitId;
    @SerializedName("must_order_before")
    @Expose
    private int mustOrderBefore;
    @SerializedName("quantity_for_the_day")
    @Expose
    private int quantityForTheDay;
    @SerializedName("available_count_for_the_day")
    @Expose
    private int availableCountForTheDay;
    @SerializedName("meal_additional_info")
    @Expose
    private String mealAdditionalInfo;
    @SerializedName("must_order_before_unit")
    @Expose
    private String mustOrderBeforeUnit;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("estimated_preparation_time")
    @Expose
    private String estimatedPreparationTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("rating")
    @Expose
    private double rating;
    @SerializedName("has_delivery")
    @Expose
    private boolean hasDelivery;
    @SerializedName("is_editing")
    @Expose
    private boolean isEditing;
    @SerializedName("is_favorite")
    @Expose
    private boolean isFavorite;
    @SerializedName("kitchen_id")
    @Expose
    private int kitchenId;

    public Object getAdditionalInfoMap() {
        return additionalInfoMap;
    }



    public boolean isIsAvailable() {
        return isAvailable;
    }



    public int getRatingCount() {
        return ratingCount;
    }



    public String getAvailabilityMessage() {
        return availabilityMessage;
    }


    public Object getAdditionalNotes() {
        return additionalNotes;
    }



    public List<MediumData> getMealMedia() {
        return mealMedia;
    }



    public int getQty() {
        return qty;
    }



    public String getMealUnit() {
        return mealUnit;
    }



    public String getAvailabilityTime() {
        return availabilityTime;
    }



    public String getName() {
        return name;
    }



    public List<MealAdditionalItem> getMealAdditionalItems() {
        return mealAdditionalItems;
    }



    public List<Long> getMealDeliveryOptions() {
        return mealDeliveryOptions;
    }



    public int getMenuId() {
        return menuId;
    }



    public String getMealCurrency() {
        return mealCurrency;
    }


    public int getUnitId() {
        return unitId;
    }


    public int getMustOrderBefore() {
        return mustOrderBefore;
    }


    public int getQuantityForTheDay() {
        return quantityForTheDay;
    }



    public int getAvailableCountForTheDay() {
        return availableCountForTheDay;
    }


    public String getMealAdditionalInfo() {
        return mealAdditionalInfo;
    }



    public String getMustOrderBeforeUnit() {
        return mustOrderBeforeUnit;
    }



    public int getPrice() {
        return price;
    }



    public String getEstimatedPreparationTime() {
        return estimatedPreparationTime;
    }


    public String getDescription() {
        return description;
    }



    public long getId() {
        return id;
    }



    public String getRating() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatter = (DecimalFormat) nf;
        formatter.applyPattern("#.#");

        return formatter.format(rating);
    }


    public boolean isHasDelivery() {
        return hasDelivery;
    }



    public boolean isIsEditing() {
        return isEditing;
    }



    public boolean isIsFavorite() {
        return isFavorite;
    }



    public long getKitchenId() {
        return kitchenId;
    }



}