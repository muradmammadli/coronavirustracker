package com.example.koronavirusapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api/")
    Call<List<stats>> getStats();

    @GET("/api/news")
    Call<List<news>> getNews();

    @GET("/v2/key-value-stores/1mPmYJOTUu8hPfhc0/records/LATEST?disableRedirect=true")
    Call<azstats> getAzstats();

}
