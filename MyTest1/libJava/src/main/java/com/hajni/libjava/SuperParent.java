package com.hajni.libjava;

public class SuperParent {

    protected int a = 10;//protected > 상속가능하게 하겠다.  //public > 밖에서 쓸수있게

    public void print(){
        System.out.println("SuperParent print()");
        System.out.println("a = " + a);
        System.out.println();

    }
}
