package com.example.leagueoflegendsapp.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.leagueoflegendsapp.R;
import com.example.leagueoflegendsapp.Singletons;
import com.example.leagueoflegendsapp.presentation.controller.DetailsController;
import com.example.leagueoflegendsapp.presentation.model.item;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtPlain;
    private TextView txtDescription;
    private TextView txtGoldBuy;
    private TextView txtGoldSell;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtName = findViewById(R.id.name);
        txtPlain = findViewById(R.id.plaintext);
        txtDescription = findViewById(R.id.description);
        txtGoldBuy = findViewById(R.id.buyGold);
        txtGoldSell = findViewById(R.id.sellGold);
        img = findViewById(R.id.img);

        Intent intent = getIntent();
        String itemJson = intent.getStringExtra("item");
        item item = Singletons.getGson().fromJson(itemJson, item.class);
        showDetail(item);
    }


    private void showDetail(item item){
        txtName.setText(item.getName());
        txtPlain.setText(item.getPlaintext());
        txtDescription.setText(DetailsController.refractorDescription(item.getDescription()));
        txtGoldBuy.setText("Coût : " + item.getGold().getTotal() + "PO");
        txtGoldSell.setText("Vente : " + item.getGold().getSell() + "PO");
        Picasso.get().load("https://raw.githubusercontent.com/VCamozzi/LeagueOfLegendsApiRest/master/10.9.1/img/item/" + item.getImage().getFull()).into(img);
    }
}

