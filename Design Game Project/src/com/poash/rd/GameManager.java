package com.poash.rd;

public class GameManager {
    private int cash;
    private GameManager(){

    }
    static GameManager instance= new GameManager();
    public static GameManager getInstance(){
        return instance;
    }
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
        Scene scene = new Scene();
        scene.Start(player);
        //Run a loop
        while(player.IsAlive()){
        //Generate gameobject (side objects, traffic, etc)
            scene.GenerateNPCs();
        //Player is driving the car
            Drive();
        //Collide with other objects
            scene.Collide();
        //Repeat until health > 0
        }
      EndGame();
    }
    private void Drive(){
        System.out.println("\nPlayer is driving");
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
    public void EndGame(){
        System.out.printf("Total cash accumulated : %d", cash);

    }
    
}
