package com.hajni.libjava;

public class PrivateMember {

    public static final int NUMBER = 100;
    int a = 10;

    final void speedUp(){ //fanal > 끝 더이상 상속받을수 없다. ,바꿀수 없다.
        a = a + 10;
    }
    void speedDown(){
        a = a - 10;
    }

}
