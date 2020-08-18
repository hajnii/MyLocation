package com.hajni.libjava;

public class Car{
    String Company = "Benz";
    String Model = "S350";
    String color = "black";
    int maxSpeed = 350;
    int speed;

    Car(int speed){
        this.speed = speed;
    }

    Car(String Company, String Model, String color){
        this.Company = Company;
        this.Model = Model;
        this.color = color;
    }
    void print(){
        System.out.println(Company);
        System.out.println(Model);
        System.out.println(color);
        System.out.println(maxSpeed);
        System.out.println(speed);
    }
}
//생성자 만들어서 스트링 세개 나오게하기