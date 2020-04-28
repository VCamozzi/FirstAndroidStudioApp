package com.example.leagueoflegendsapp;

import java.util.List;

public class RestPokemonResponse {

    private int count;
    private String next;
    private List<Pokemon> result;


    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Pokemon> getResult() {
        return result;
    }
}
