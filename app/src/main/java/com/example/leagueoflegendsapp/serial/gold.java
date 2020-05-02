package com.example.leagueoflegendsapp.serial;

class gold {

    private float base;
    private boolean purchasable;
    private float total;
    private float sell;


    // Getter Methods

    public float getBase() {
        return base;
    }

    public boolean getPurchasable() {
        return purchasable;
    }

    public float getTotal() {
        return total;
    }

    public float getSell() {
        return sell;
    }

    // Setter Methods

    public void setBase(float base) {
        this.base = base;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }
}
