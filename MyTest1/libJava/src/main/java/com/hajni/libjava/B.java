package com.hajni.libjava;

public class B extends A {

    @Override
    void hello() {
        super.hello();
    }
}
//    @Override //부모한테 받은 이름만 적용하고 임의로 바꿈
//    void hello(){
//        System.out.println("B say hello");
//        System.out.println("hahahahaha");
//    }