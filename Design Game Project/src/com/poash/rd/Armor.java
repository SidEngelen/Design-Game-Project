package com.poash.rd;

public class Armor extends Powerup {

    @Override
    public void ApplyPowerup(Player player, int damage, int cash){
        int totalDamage = player.GetPlayerVehicle().getStrength() + damage / 2;
        player.GetPlayerHealth().SetUnits(player.GetPlayerHealth().GetUnits() - totalDamage);
    GameManager.instance.AddCash(cash);
    if(--countdown == 0){
        player.SetPowerup(new NoPowerup());
    }
    }
    @Override
    public void onCollision(GameObject other){
        if(other.getTag() == "Player"){
            System.out.println("*************************************************");
            System.out.println("******************   ARMOR   ********************");
            System.out.println("*************************************************");
            Player p = (Player)other;
            p.SetPowerup(this);
        }
    }
    @Override
    public String toString(){
        return "ARMOR:" + countdown;
    }
}
