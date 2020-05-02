package com.example.leagueoflegendsapp.serial;

import java.util.ArrayList;

public class Items {

    private String type;
    private String version;

    //private basic basic;
    private ArrayList<item> data = new ArrayList<item>();
    private ArrayList<groups> groups = new ArrayList<groups>();
    private ArrayList<tree> tree = new ArrayList<tree>();



    public ArrayList<com.example.leagueoflegendsapp.serial.groups> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<com.example.leagueoflegendsapp.serial.groups> groups) {
        this.groups = groups;
    }

    public ArrayList<com.example.leagueoflegendsapp.serial.tree> getTree() {
        return tree;
    }

    public void setTree(ArrayList<com.example.leagueoflegendsapp.serial.tree> tree) {
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


    public ArrayList<item> getData() {
        return data;
    }

    public void setData(ArrayList<item> data) {
        this.data = data;
    }
}

