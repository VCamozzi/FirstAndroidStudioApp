package com.example.leagueoflegendsapp.presentation.controller;

public class DetailsController {

    public static String refractorDescription(String description){
        String sautLigne = System.getProperty("line.separator");
        description = description.replaceAll("\\<.*?\\>", sautLigne);
        return description;
    }
}
