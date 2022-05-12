package com.poash.rd;

public class Player extends GameObject {
    private int health;
    private PlayerVehicle vehicle;
    public Player(int health, PlayerVehicle vehicle) {
        super();
        this.health = health;
        this.vehicle = vehicle;
        setName("Player");
    }
    public boolean IsAlive(){
        return health > 0;
    }
    public void ApplyDamage(int damage, int cash){
        health -= damage - vehicle.getStrength();
        System.out.printf("Player health:%d\n", health < 0 ? 0 : health);
        GameManager.getInstance().AddCash(cash);
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
