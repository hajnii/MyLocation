package com.hajni.libjava;

public class Parent extends GrandParent{

    protected String job;

    Parent(){
        System.out.println("Parent class");
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("job : " + job);
    }
}

//    void printParenInfo(){
//        System.out.println("name : " + name);
//        System.out.println("age : " + age);
//        System.out.println("job : " + job);
//    }