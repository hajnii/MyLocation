package com.hajni.libjava;

public class GrandParent {

    protected String name;
    protected int age;

    GrandParent(){
        System.out.println("GrandParent class");
    }

    public void printInfo(){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }

}
