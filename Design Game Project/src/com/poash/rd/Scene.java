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
        switch(spawnIndex){
            case 0:
                new HealthKit().onCollision(player);
                break;
        }
    }
    private void GeneratePowerups() {
        int spawnIndex = random.nextInt(10);
        switch(player.GetPlayerHealth().GetPlayerState()){
            case HEALTHY:    if(spawnIndex < 2)
                    CreatePowerup(0);
                    break;
            case INJURED:    if(spawnIndex < 4)
                    CreatePowerup(0);
                    break;
            case CRITICAL:    if(spawnIndex < 8)
                    CreatePowerup(0);
                    break;
            case DEAD:
            break;
        }
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
        
        SideObject sideObject = null;
        switch(random.nextInt(SIDEOBJECT_COUNT)){
            case 0: //firehydrant
                sideObject = new FireHydrant(5, 10);
                break;
            case 1: //letterbox
                sideObject =  new LetterBox(8, 13);
                break;

        }
        sideList.add(sideObject);
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
        Vehicle vehicle = null;
        switch(random.nextInt(TRAFFIC_COUNT)){
            case 0: //sedan
                vehicle = new Sedan(15, 80);
                break;
            case 1: //van
                vehicle = new Van(18, 90);
                break;

        }
        trafficList.add(vehicle);
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
