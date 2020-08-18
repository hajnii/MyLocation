package com.hajni.libjava;

public class While {
    public static void main(String[] args) {
       //1부터 10000까지 수를 곱합니다.
       //단, 곱한값이 7000보다 크면, 곱한값을 출력하고 종료,
        double value = 1;
        for(int i = 1; i <= 10000; i++){
            value = value * i;
            if(value > 7000){
                System.out.println(value);
                break;
            }
        }
    }
}
// while(i < 100){
//        if(i == 5){
//        System.out.println("Hello");
//        i = 99;
//        continue;
//        }
//        System.out.println(i);
//        i++;
//        }
//구구단   for(int step = 9; step >= 2; step--) {
//        for (int i = 9; i >= 1; i--) {
//        System.out.println(step + "X" + i + "=" + (step * i));
//        }
//        }

//    int sum = 0;
//    int i = 1;
//    while( i <= 100 )
//    sum = sum + i;
//    i++;// i = i + 1;
//    System.out.println(sum);
// a 의 cnt 승을 하는 프로그램.
// 2 의 4 승을 구하는 프로그램.

//    int a = 2;
//    int cnt = 4;
//    int data = 1;
//        for(int i = 0; i < cnt; i++){
//        data = data * a;
//        }
//        System.out.println(data);

