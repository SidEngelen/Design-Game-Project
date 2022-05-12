package com.poash.rd;

public  class Sedan extends TrafficCar {
    public Sedan(int damage, int cash){
        super(damage, cash);
        setName("Sedan");
    }
     @Override
     public void onCollision(GameObject other) {
        if(other.getName().equals("Player")){
            Player player = (Player) other;
              System.out.println("#### COLLISION -> [Sedan] Sparks flying");
              player.ApplyDamage(getDamage(), getCash());
            
        }
     }
}
