package com.poash.rd;

public  class Van extends TrafficCar {
    public Van(int damage, int cash){
        super(damage, cash);
    }
     @Override
     public void onCollision(GameObject other) {
         // TODO Auto-generated method stub
         super.onCollision(other);
     }
}
