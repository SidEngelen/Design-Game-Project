package com.poash.rd;

public class Player extends GameObject {
    private PlayerHealth playerHealth = new PlayerHealth();
    private PlayerVehicle vehicle;
    public Player(int health, PlayerVehicle vehicle) {
        super();
        playerHealth.SetUnits(health);
        this.vehicle = vehicle;
    }
    public boolean IsAlive(){
        return playerHealth.GetPlayerState() != PlayerState.DEAD;
    }
    public void ApplyDamage(int damage, int cash){
        int newHealth = playerHealth.GetUnits() - damage - vehicle.getStrength();
        playerHealth.SetUnits(newHealth);
        GameManager.getInstance().AddCash(cash);
    }
    public void Drive(){
        System.out.printf("\nPlayer is driving [Health:%d]\n", playerHealth.GetUnits());
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("");
    }
    public void Acclerate(){
        vehicle.Up();
    }
    public void Brake(){
        vehicle.Down();
    }
    public void SteerLeft(){
        vehicle.Left();
    }public void SteerRight(){
        vehicle.Right();
    }
}
