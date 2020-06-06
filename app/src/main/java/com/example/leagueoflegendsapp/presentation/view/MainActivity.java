package com.example.leagueoflegendsapp.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.example.leagueoflegendsapp.R;
import com.example.leagueoflegendsapp.Singletons;
import com.example.leagueoflegendsapp.presentation.controller.MainController;
import com.example.leagueoflegendsapp.presentation.model.item;
import com.google.gson.GsonBuilder;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
        );
        controller.onStart();

    }

    public void showList(List<item> itemList) {

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


    public void showError() {
        Toast.makeText(getApplicationContext(), "Api Error", Toast.LENGTH_SHORT).show();
    }
    
}
