package com.example.leagueoflegendsapp.display;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.leagueoflegendsapp.R;

class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    TextView txtHeader;
    TextView txtFooter;
    ImageView img;
    View layout;

    ViewHolder(View v) {
        super(v);
        layout = v;
        txtHeader = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        img = (ImageView) v.findViewById(R.id.icon);
    }
}
