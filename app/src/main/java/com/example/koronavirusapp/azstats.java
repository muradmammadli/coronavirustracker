package com.example.koronavirusapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class azstats {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("infected")
    @Expose
    private Integer infected;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deceased")
    @Expose
    private Integer deceased;
    @SerializedName("tested")
    @Expose
    private Integer tested;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;
    @SerializedName("lastUpdatedAtApify")
    @Expose
    private String lastUpdatedAtApify;
    @SerializedName("lastUpdatedAtSource")
    @Expose
    private String lastUpdatedAtSource;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getInfected() {
        return infected;
    }

    public void setInfected(Integer infected) {
        this.infected = infected;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public Integer getTested() {
        return tested;
    }

    public void setTested(Integer tested) {
        this.tested = tested;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLastUpdatedAtApify() {
        return lastUpdatedAtApify;
    }

    public void setLastUpdatedAtApify(String lastUpdatedAtApify) {
        this.lastUpdatedAtApify = lastUpdatedAtApify;
    }

    public String getLastUpdatedAtSource() {
        return lastUpdatedAtSource;
    }

    public void setLastUpdatedAtSource(String lastUpdatedAtSource) {
        this.lastUpdatedAtSource = lastUpdatedAtSource;
    }

}
