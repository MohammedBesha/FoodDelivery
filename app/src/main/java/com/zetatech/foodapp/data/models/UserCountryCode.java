package com.zetatech.foodapp.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCountryCode {

    @SerializedName("nice_name")
    @Expose
    private String niceName;
    @SerializedName("currency_lookup_id")
    @Expose
    private long currencyLookupId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_code")
    @Expose
    private long phoneCode;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("iso")
    @Expose
    private String iso;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("has_state")
    @Expose
    private boolean hasState;

    public String getNiceName() {
        return niceName;
    }


    public long getCurrencyLookupId() {
        return currencyLookupId;
    }



    public String getName() {
        return name;
    }


    public long getPhoneCode() {
        return phoneCode;
    }


    public String getFlag() {
        return flag;
    }


    public String getIso3() {
        return iso3;
    }


    public String getIso() {
        return iso;
    }


    public long getId() {
        return id;
    }


    public boolean isHasState() {
        return hasState;
    }


}
