package com.poash.rd;

import java.util.HashMap;

public class VehicleFactory {
    private HashMap<Integer, CallbackVehicle> callbacks = new HashMap<>();
    private static VehicleFactory instance = new VehicleFactory();
    private VehicleFactory(){

    }
    public void RegisterCallbackVehicle(int key, CallbackVehicle callback){
        callbacks.put(key, callback);
    }
    public Vehicle CreateVehicle(int key){
        CallbackVehicle cb = callbacks.get(key);
        return cb.CreateV();
    }
    public static VehicleFactory GetInstance(){
        return instance;
    }
    
}
