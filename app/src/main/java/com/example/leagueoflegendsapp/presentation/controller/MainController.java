package com.example.leagueoflegendsapp.presentation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.leagueoflegendsapp.Constants;
import com.example.leagueoflegendsapp.data.LolApi;
import com.example.leagueoflegendsapp.presentation.model.Items;
import com.example.leagueoflegendsapp.presentation.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharedPreferences){
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart(){
        Items items = getDataFromCache();

        if (items != null){
            view.showList(items.getData());
        }else{
            makeApiCall();
        }

    }


    private void makeApiCall(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LolApi lolApi = retrofit.create(LolApi.class);

        Call<Items> call = lolApi.getLolResponse();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                if(response.isSuccessful() && response.body() != null){
                    Items ItemsResponse = response.body();
                    saveList(ItemsResponse);
                    view.showList(ItemsResponse.getData());

                }else{
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                view.showError();
            }
        });
    }


    private void saveList(Items itemsResponse) {
        String jsonString = gson.toJson(itemsResponse);

        sharedPreferences
                .edit()
                .putString(Constants.KEY_ITEMS, jsonString)
                .apply();
        //Toast.makeText(getApplicationContext(), "Json saved", Toast.LENGTH_SHORT).show();
    }


    private Items getDataFromCache() {

        String jsonItems = sharedPreferences.getString(Constants.KEY_ITEMS, null);
        if (jsonItems == null){
            return null;
        }else{
            return gson.fromJson(jsonItems, Items.class);
        }
    }

}
