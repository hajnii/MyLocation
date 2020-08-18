package com.hajni.libjava;

public class Array {
    public static void main(String[] args) {
        int[] number_arr = {6, 7, -33, 123, -1, 0, 392, -742};
        // 1.음수의 갯수출력
        int minus_cnt = 0;
        for (int i = 0; i < number_arr.length; i++) {
            if (number_arr[i] < 0) {
                minus_cnt++;
            }
        }
        System.out.println("minus_cnt : " + minus_cnt);

        // 2.역순으로 출력하기

        for (int i = 7; i >= 0; i--) {
            System.out.print(number_arr[i] + " ");
        }
        // 3.최대값 고르기
        System.out.println();
        System.out.println();
        int max = 0;
        for (int i = 0; i < number_arr.length; i++) {
            if (i == 0) {
                max = number_arr[i];
            } else {
                if (number_arr[i] > max) {
                    max = number_arr[i];
                }
            }
        }
        System.out.println(max);
    }
}
//예시2   // array 배열
//    // 6의 배수가 되는 학생들에게는 가산점을 줍니다.
//    // 6의 배수가 되는 학생들 점수는 40점을 줍니다.
//    int[] score_arr = new int[20];
//        for (int i = 0; i < score_arr.length; i++) {
//        if (i % 6 == 0) {
//        score_arr[i] = 40;
//        } else {
//        score_arr[i] = 30;
//        }
//        }
//        for (int i = 0; i < score_arr.length; i++) {
//        System.out.println(score_arr[i]);
//        }

//    int[] arr = new int[5];
//
//    int[] arr2 = {1,2,3};
//
//        arr[0] = 100;
//                arr[1] = 88;
//                arr[2] = 70;
//                arr[3] = 99;
//                arr[4] = 66;
//
//                System.out.println(arr[2]);
//                System.out.println(arr2[2]);
//                System.out.println(arr[0]);
//                arr[4] = 10;
//                System.out.println(arr[4]);