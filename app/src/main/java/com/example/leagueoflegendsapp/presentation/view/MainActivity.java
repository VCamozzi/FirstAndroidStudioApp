package com.example.leagueoflegendsapp.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.leagueoflegendsapp.Constants;
import com.example.leagueoflegendsapp.R;
import com.example.leagueoflegendsapp.data.LolApi;
import com.example.leagueoflegendsapp.presentation.view.ListAdapter;
import com.example.leagueoflegendsapp.presentation.model.Items;
import com.example.leagueoflegendsapp.presentation.model.item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    private static final String BASE_URL = "https://raw.githubusercontent.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("application_Lol", Context.MODE_PRIVATE);

        gson = new GsonBuilder()
                .setLenient()
                .create();

        Items items = getDataFromCache();

        if (items != null){
            showList(items.getData());
        }else{
            makeApiCall();
        }
    }

    private Items getDataFromCache() {

        String jsonItems = sharedPreferences.getString(Constants.KEY_ITEMS, null);
        if (jsonItems == null){
            return null;
        }else{
            return gson.fromJson(jsonItems, Items.class);
        }
    }


    private void showList(List<item> itemList) {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new ListAdapter(itemList);
        recyclerView.setAdapter(mAdapter);
    }


        private void makeApiCall(){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
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
                        showList(ItemsResponse.getData());

                    }else{
                        showError();
                    }
                }

                @Override
                public void onFailure(Call<Items> call, Throwable t) {
                    showError();
                }
            });
        }

    private void saveList(Items itemsResponse) {
        String jsonString = gson.toJson(itemsResponse);
        sharedPreferences
                .edit()
                .putString(Constants.KEY_ITEMS, jsonString)
                .apply();
        Toast.makeText(getApplicationContext(), "Json saved", Toast.LENGTH_SHORT).show();
    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "Api Error", Toast.LENGTH_SHORT).show();
    }
    
}
