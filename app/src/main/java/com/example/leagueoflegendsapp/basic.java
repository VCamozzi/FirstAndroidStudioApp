package com.example.leagueoflegendsapp;

import java.util.ArrayList;
import java.util.List;

public class basic {

    private String name;
    private String group;
    private String description;
    private String colloq;
    private String plaintext;
    private String requiredChampion;
    private String requiredAlly;

    private boolean consumed;
    private boolean consumeOnFull;
    private boolean inStore;
    private boolean hideFromAll;

    private int depth;
    private int stacks;
    private int specialRecipe;

    private ArrayList<String> from = new ArrayList<String>();
    private ArrayList<String> into = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();

    private rune rune;
    private gold gold;
    private stats stats;
    private maps maps;

}
