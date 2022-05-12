package com.poash.rd;

public class SideObject extends GameObject {
    private int damage;
    private int cash;
    protected int count;
    public int getDamage() {
        return this.damage;
    }

    public final void setDamage(int damage) {
        this.damage = damage;
    }

    public final int getCash() {
        return this.cash;
    }

    public final void setCash(int cash) {
        this.cash = cash;
    }

    public SideObject(int damage, int cash) {
        super();
        this.damage = damage;
        this.cash = cash;
        count = 0;
    }

 
}
