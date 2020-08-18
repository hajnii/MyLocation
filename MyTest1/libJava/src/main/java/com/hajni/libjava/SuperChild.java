package com.hajni.libjava;

public class SuperChild extends SuperParent{

    int a = 20;

    @Override
    public void print(){
        System.out.println("SuperChild print()");
        System.out.println("a = " + a );
        System.out.println();
    }
    public void superCall(){
        System.out.println("sper.a = " + super.a);
        super.print();
    }
}
