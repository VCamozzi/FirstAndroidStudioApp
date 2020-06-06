package com.example.leagueoflegendsapp.data;

import com.example.leagueoflegendsapp.presentation.model.Items;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LolApi {

    @GET("/VCamozzi/LeagueOfLegendsApiRest/master/10.9.1/data/fr_FR/item.json")
    Call<Items> getLolResponse();
}
