package com.hajni.libjava;

public class ChildAirplane extends AirPlane{
    int flyMode = 1;

    @Override
    void fly() {
        if(flyMode == 1){
            super.fly();
        }else {
            System.out.println("Child Flying.");
        }
    }
}
