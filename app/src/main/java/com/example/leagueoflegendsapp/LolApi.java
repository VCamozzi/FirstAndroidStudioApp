package com.example.leagueoflegendsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LolApi {

    @GET("/item.json")
    Call<Items> getLolResponse();
}
