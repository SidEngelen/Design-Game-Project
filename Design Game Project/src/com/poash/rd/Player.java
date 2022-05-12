package com.poash.rd;

public class Player extends GameObject {
    private int health;
    private PlayerVehicle vehicle;
    public Player(int health, PlayerVehicle vehicle) {
        super();
        this.health = health;
        this.vehicle = vehicle;
    }
    public boolean IsAlive(){
        return health > 0;
    }
    public void ApplyDamage(int damage, int cash){
        health -= damage - vehicle.getStrength();
        GameManager.getInstance().AddCash(cash);
    }
    public void Drive(){
        System.out.printf("\nPlayer is driving [Health:%d]\n", health < 0 ? 0 : health);
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
