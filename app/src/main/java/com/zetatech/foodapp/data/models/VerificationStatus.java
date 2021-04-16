package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificationStatus {

    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("account")
    @Expose
    private String account;

    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }


    public String getAccount() {
        return account;
    }


}