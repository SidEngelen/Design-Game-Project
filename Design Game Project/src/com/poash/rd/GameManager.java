package com.poash.rd;

public class GameManager {
    private int cash;
    public int GetCash(){
        return cash;
    }
    public void AddCash(int amount){
        cash += amount;
    }
    public void NewGame(){
        //Choose Vehicle
        PlayerVehicle vehicle = new PlayerVehicle("Sedan", 5, 70, 4);
        //Create a player object
        Player player = new Player(100, vehicle);
        player.setName("Player");
        
        //Prepare the scenery
        //Run a loop
        while(player.IsAlive()){
        //Generate gameobject (side objects, traffic, etc)

        //Collide with other objects

        //Repeat until health = 0
        }
      
    }
    public void EndGame(){
        System.out.printf("Total cash accumulated : %d", cash);

    }
    
}
