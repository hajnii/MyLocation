package com.hajni.libjava;

public class ParentXX {

    public String name;
    protected int age;
    private int money;  // private : 해당클래스 안에서만 쓸 수 있다. ,비공개

    ParentXX(){
        System.out.println("Parent class init");
    }

    void printParentIfo(){
        System.out.println("name : "+ name);
        System.out.println("age : "+ age);
    }

    int getMoney(){
        return money;
    }
    void setMoney(int money){
        this.money = money;
    }

}
