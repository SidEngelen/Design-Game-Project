package com.poash.rd;

import java.util.ArrayList;
import java.util.Random;

public class Scene {
    private static final int SIDEOBJECT_COUNT = 2;
    private static final int TRAFFIC_COUNT = 2;
    private static final int NPC_TYPES = 2;
    private ArrayList<TrafficCar> trafficList = new ArrayList<>();
    private ArrayList<SideObject> sideList = new ArrayList<>();
    private Player player;
    private Random random = new Random();

    public void Start(Player player){
        this.player = player;
    }
    public void GenerateNPCs(){
        if(sideList.size() > 6) {
            sideList.remove(0);
        }
        if(trafficList.size() > 6) {
            trafficList.remove(0);
        }
        sideList.add(GenerateSideObject());
        trafficList.add(GenerateTraffic());
        DisplaySideObjects();
        DisplayTraffic();
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
        if(go != null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private SideObject GenerateSideObject(){
        switch(random.nextInt(SIDEOBJECT_COUNT)){
            case 0: //firehydrant
                return new FireHydrant(5, 10);
            case 1: //letterbox
                return new LetterBox(8, 13);

        }
        return null;
    }
    private TrafficCar GenerateTraffic(){
        switch(random.nextInt(TRAFFIC_COUNT)){
            case 0: //sedan
                return new Sedan(15, 80);
            case 1: //van
                return new Van(18, 90);

        }
        return null;
    }
    private void DisplaySideObjects(){
        System.out.println("<<<<< SIDEOBJECTS >>>>>");
        for(SideObject obj : sideList){
            System.out.println(obj.getName());
        }
    }
    private void DisplayTraffic(){
        System.out.println("<<<<< TRAFFIC >>>>>");
        for(TrafficCar obj : trafficList){
            System.out.println(obj.getName());
        }
    }
}
