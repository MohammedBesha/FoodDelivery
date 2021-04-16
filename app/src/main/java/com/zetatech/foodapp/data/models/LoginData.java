package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {


    @SerializedName("location")
    @Expose
    private LocationData location;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("user_country_code")
    @Expose
    private UserCountryCode userCountryCode;
    @SerializedName("verification_status")
    @Expose
    private VerificationStatus verificationStatus;
    @SerializedName("kitchen_id")
    @Expose
    private Object kitchenId;
    @SerializedName("unseen_notification_count")
    @Expose
    private long unseenNotificationCount;
    @SerializedName("is_account_completed")
    @Expose
    private boolean isAccountCompleted;

    public LocationData getLocation() {
        return location;
    }


    public String getLastName() {
        return lastName;
    }


    public String getType() {
        return type;
    }


    public Object getEmail() {
        return email;
    }


    public long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getPhone() {
        return phone;
    }


    public UserCountryCode getUserCountryCode() {
        return userCountryCode;
    }


    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }



    public Object getKitchenId() {
        return kitchenId;
    }



    public long getUnseenNotificationCount() {
        return unseenNotificationCount;
    }


    public boolean isIsAccountCompleted() {
        return isAccountCompleted;
    }



}