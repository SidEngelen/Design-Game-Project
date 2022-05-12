package com.poash.rd;

public class NoPowerup extends Powerup {

    @Override
    public void ApplyPowerup(Player player, int damage, int cash){
        int newHealth = player.GetPlayerHealth().GetUnits() - damage - player.GetPlayerVehicle().getStrength();
        player.GetPlayerHealth().SetUnits(newHealth);
        GameManager.getInstance().AddCash(cash);
    }
    
}
