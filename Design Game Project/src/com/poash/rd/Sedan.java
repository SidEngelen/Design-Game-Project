package com.poash.rd;

public  class Sedan extends TrafficCar {
    public Sedan(int damage, int cash){
        super(damage, cash);
    }
     @Override
     public void onCollision(GameObject other) {
         // TODO Auto-generated method stub
         super.onCollision(other);
     }
}
