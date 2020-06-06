package com.example.leagueoflegendsapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.leagueoflegendsapp.data.LolApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singletons {

    private static Gson gsonInstance;
    private static LolApi lolApiInstance;
    private static SharedPreferences sharedPreferencesInstance;

    public static Gson getGson(){

        if (gsonInstance == null){
            gsonInstance = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gsonInstance;
    }


    public static LolApi getLolApi(){

        if (lolApiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            lolApiInstance = retrofit.create(LolApi.class);
        }
        return lolApiInstance;
    }


    public static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferencesInstance == null){
            sharedPreferencesInstance = context.getSharedPreferences("application_Lol", Context.MODE_PRIVATE);
        }
        return sharedPreferencesInstance;
    }
}
