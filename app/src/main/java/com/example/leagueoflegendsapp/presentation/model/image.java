package com.example.leagueoflegendsapp.presentation.model;

public class image {

    private String full;
    private String sprite;
    private String group;

    private float x;
    private float y;
    private float w;
    private float h;

    public String getFull() {
        return full;
    }

    public String getSprite() {
        return sprite;
    }

    public String getGroup() {
        return group;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getW() {
        return w;
    }

    public float getH() {
        return h;
    }

    // Setter Methods

    public void setFull(String full) {
        this.full = full;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setH(float h) {
        this.h = h;
    }
}
