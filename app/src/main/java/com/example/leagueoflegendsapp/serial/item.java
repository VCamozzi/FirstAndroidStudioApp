package com.example.leagueoflegendsapp.serial;

import java.util.ArrayList;

class item {

    private String name;
    private String description;
    private String colloq;
    private String plaintext;

    private ArrayList<String> into = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();

    private image image;
    private gold gold;
    private maps maps;
    private stats stats;

    // GETTER

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColloq() {
        return colloq;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public ArrayList<String> getInto() {
        return into;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public com.example.leagueoflegendsapp.serial.image getImage() {
        return image;
    }

    public com.example.leagueoflegendsapp.serial.gold getGold() {
        return gold;
    }

    public com.example.leagueoflegendsapp.serial.maps getMaps() {
        return maps;
    }

    public com.example.leagueoflegendsapp.serial.stats getStats() {
        return stats;
    }


    //SETTER


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public void setInto(ArrayList<String> into) {
        this.into = into;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setImage(com.example.leagueoflegendsapp.serial.image image) {
        this.image = image;
    }

    public void setGold(com.example.leagueoflegendsapp.serial.gold gold) {
        this.gold = gold;
    }

    public void setMaps(com.example.leagueoflegendsapp.serial.maps maps) {
        this.maps = maps;
    }

    public void setStats(com.example.leagueoflegendsapp.serial.stats stats) {
        this.stats = stats;
    }
}
