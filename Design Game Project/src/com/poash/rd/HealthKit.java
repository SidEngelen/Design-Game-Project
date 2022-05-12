package com.poash.rd;

public class HealthKit extends Powerup {

    @Override
    public void ApplyPowerup(Player player, int damage, int cash){
        // Auto-generated method stub
    }

    @Override
    public void onCollision(GameObject other){
        if(other.getTag().equalsIgnoreCase("Player")){
            System.out.println("*************************************************");
            System.out.println("**************   HEALTHKIT   ********************");
            System.out.println("*************************************************");
            Player p = (Player)other;
            int newHealth = p.GetPlayerHealth().GetUnits() + 25;
            p.GetPlayerHealth().SetUnits(newHealth);
        }
    }
    
}
