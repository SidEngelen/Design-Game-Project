package com.poash.rd;

import java.util.ArrayList;
import java.util.Random;

public class Scene {
    private static final int SIDEOBJECT_COUNT = 2;
    private static final int TRAFFIC_COUNT = 2;
    private static final int NPC_TYPES = 2;
    private ArrayList<Vehicle> trafficList = new ArrayList<>();
    private ArrayList<SideObject> sideList = new ArrayList<>();
    private Player player;
    private Random random = new Random();

    public void Start(Player player){
        this.player = player;
    }
    public void Execute(){
        GenerateSideObject();
        GenerateTraffic();
        GeneratePowerups();
        DisplaySideObjects();
        DisplayTraffic();
        Collide();
    }
    private void CreatePowerup(int spawnIndex){
       
    }
    private void GeneratePowerups() {
        int spawnIndex = 0;
        switch(player.GetPlayerHealth().GetPlayerState()){
            case HEALTHY:   
                spawnIndex = random.nextInt(10); 
                    break;
            case INJURED:    
                spawnIndex = random.nextInt(6); 
                    break;
            case CRITICAL:    
                spawnIndex = random.nextInt(3); 
                    break;
            case DEAD:
                spawnIndex = 100;
            break;
        }
        if(spawnIndex < Powerup.POWERUP_COUNT)
            if(spawnIndex != 0 && player.GetPowerup().IsActive())
            return;
            PowerupFactory.CreatePowerup(spawnIndex).onCollision(player);
    }
    public void Collide(){
        GameObject go = null;
        if(random.nextBoolean() == false)
            return;
        switch(random.nextInt(NPC_TYPES)){
            case 0: //Sideobjects
                go = sideList.get(random.nextInt(sideList.size()));
                break;
            case 1: //Traffic
                go = trafficList.get(random.nextInt(trafficList.size()));
                break;

        }
        go.onCollision(player);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }
    private void GenerateSideObject(){

        switch(player.GetPlayerHealth().GetPlayerState()){
            case HEALTHY:
            if(sideList.size() > 6) {
                sideList.remove(0);
            }
            break;
            case INJURED:
            if(sideList.size() > 4) {
                sideList.remove(0);
            }
            break;
            case CRITICAL:
            if(sideList.size() > 2) {
                sideList.remove(0);
            }
            break;
            case DEAD:
            break;
        }
        
        sideList.add(SideObjectFactory.GetInstance().CreateSideObject(random.nextInt(SIDEOBJECT_COUNT)));
    }
    private void GenerateTraffic(){
        switch(player.GetPlayerHealth().GetPlayerState()){
            case HEALTHY:
            if(trafficList.size() > 6) {
                trafficList.remove(0);
            }
            break;
            case INJURED:
            if(trafficList.size() > 4) {
                trafficList.remove(0);
            }
            break;
            case CRITICAL:
            if(trafficList.size() > 2) {
                trafficList.remove(0);
            }
            break;
            case DEAD:
            break;
        }
        trafficList.add(VehicleFactory.GetInstance().CreateVehicle(random.nextInt(TRAFFIC_COUNT)));
    }
    private void DisplaySideObjects(){
        System.out.println("<<<<< SIDEOBJECTS >>>>>");
        for(SideObject obj : sideList){
            System.out.println(obj.getName());
        }
    }
    private void DisplayTraffic(){
        System.out.println("<<<<< TRAFFIC >>>>>");
        for(Vehicle obj : trafficList){
            System.out.println(obj.getName());
        }
    }
}
