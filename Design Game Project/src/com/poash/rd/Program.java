package com.poash.rd;

public class Program {

    private static void Initialize(){
        SideObjectFactory.GetInstance().RegisterCallback(0, ()-> {return new LetterBox(8, 13);});
        SideObjectFactory.GetInstance().RegisterCallback(1, ()-> {return new FireHydrant(5, 10);});
        VehicleFactory.GetInstance().RegisterCallbackVehicle(0, ()-> {return new Sedan(15, 80);});
        VehicleFactory.GetInstance().RegisterCallbackVehicle(1, ()-> {return new Van(18, 90);});
    }
    public static void main(String[] args) {
        Initialize();
        GameManager.getInstance().NewGame();
    }
}
