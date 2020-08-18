package com.hajni.libjava;

public class Calculator {

    ///method , 화면에 "Power On"이라고 출력하는 메소드
    void powerOn(){
        System.out.println("Power On");
    }
    ///plus 3개의 정수를 입력받아서 합을 리ㅓㄴ하는 메소드

    int plus(int a, int b, int c){
        int result = a + b + c;
        return result;
    }
    double divide(int a, int b){
        double result = (double) a / b;
        return result;
    }

}
