package com.poash.rd;

public class Vehicle extends GameObject {
    private int damage ;
    private int cash ;
    public Vehicle(int damage, int cash){
        this.damage = damage;
        this.cash = cash;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

}
