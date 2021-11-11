package com.example.ecommerceairlift.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("rate")
    @Expose
    private float rate;

    @SerializedName("count")
    @Expose
    private float count;


    // Getter Methods

    public float getRate() {
        return rate;
    }

    public float getCount() {
        return count;
    }

    // Setter Methods

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setCount(float count) {
        this.count = count;
    }
}
