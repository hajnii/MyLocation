package com.hajni.libjava;

public class For {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 100; i = i + 1){// i++
            if(i % 2 == 1){
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}

//    예제2    for(int i = 0; i < 5; i = i + 2){
//            System.out.println(i);
//            System.out.println("Hello");
//    예제1    for(int a = 0; a <= 10; a++){ //a++ 는 a +1
//            System.out.println(a);