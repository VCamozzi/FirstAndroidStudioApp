package com.example.leagueoflegendsapp;

import java.util.ArrayList;

public class Items {

    private String type;
    private String version;

    //private basic basic;
    private data data;
    private ArrayList<groups> groups = new ArrayList<groups>();
    private ArrayList<tree> tree = new ArrayList<tree>();



    public ArrayList<com.example.leagueoflegendsapp.groups> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<com.example.leagueoflegendsapp.groups> groups) {
        this.groups = groups;
    }

    public ArrayList<com.example.leagueoflegendsapp.tree> getTree() {
        return tree;
    }

    public void setTree(ArrayList<com.example.leagueoflegendsapp.tree> tree) {
        this.tree = tree;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public com.example.leagueoflegendsapp.data getData() {
        return data;
    }

    public void setData(com.example.leagueoflegendsapp.data data) {
        this.data = data;
    }
}

