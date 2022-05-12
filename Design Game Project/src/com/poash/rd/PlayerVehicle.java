package com.poash.rd;

public class PlayerVehicle {
    public PlayerVehicle(String name, int handling, int topSpeed, int strength) {
        super();
        this.name = name;
        this.handling = handling;
        this.topSpeed = topSpeed;
        this.strength = strength;
    }
    private String name;
    private int handling;
    private int topSpeed;
    private int strength;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHandling() {
        return this.handling;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void Up(){

    }
    public void Down(){

    }
    public void Left(){

    }
    public void Right(){
        
    }

    
    
}
