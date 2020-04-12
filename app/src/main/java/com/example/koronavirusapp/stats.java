package com.example.koronavirusapp;

import com.google.gson.annotations.SerializedName;

public class stats {

    @SerializedName("country")
    public String country;

    @SerializedName("new_cases")
    public String new_cases;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }

    public stats(String country, String new_cases, String new_deaths, String total_cases, String total_deaths, String total_recovered) {
        this.country = country;
        this.new_cases = new_cases;
        this.new_deaths = new_deaths;
        this.total_cases = total_cases;
        this.total_deaths = total_deaths;
        this.total_recovered = total_recovered;
    }

    @SerializedName("new_deaths")
    public String new_deaths;

    @SerializedName("total_cases")
    public String total_cases;

    @SerializedName("total_deaths")
    public String total_deaths;

    @SerializedName("total_recovered")
    public String total_recovered;

}
