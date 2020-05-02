package com.example.leagueoflegendsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LolApi {

    @GET("/VCamozzi/LeagueOfLegendsApiRest/master/10.9.1/data/fr_FR/item.json")
    Call<Items> getLolResponse();
}
