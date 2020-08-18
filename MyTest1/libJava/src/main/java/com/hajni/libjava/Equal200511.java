package com.hajni.libjava;

public class Equal200511 {
//    // 4. 숫자 2개를 함수입력받으면, 앞의 숫자에 뒤의 숫자 승을 하여, 결과를 리턴하는 함수를 만드세요.
//    static double get_pow(int num, int cnt) {
//        int result = 1;
//        for (int i = 0; i < cnt; i++) {
//            result = result * num;
//        }
//        return result;
//    }

//    3-1 과일등급구하기
//    if (size >= 16 && size <= 30) {
//        return "A";
//    } else if (size >= 8 && size <= 15) {
//        return "B";
//    } else if (size >= 1 && size <= 7) {
//        return "C";
//    }
//        return "Size is Wrong";



//    // 2-1. 숫자를 파라미터로 받으면, 해당숫자만큼 "hello"를 출력하는 함수.
//    static void say_hello_cnt(int cnt){
//        for (int i = 0; i < cnt; i++){
//            System.out.println("hello");
//        }


    // 1-1 숫자 3개의 평균을 리턴하는 함수를 만드세요
//        static double get_average(int a, int b, int c) {
//        double average = (a + b + c) / 3;
//        return average;
//   하진이푼거     double d = 0;
//                  d = a + b + c / 3;
//                  return d;


//    // parameters, arguments
//    static int add(int a, int b) { // int a = 3; int b = 4;
//        int c = 0;
//        c = a + b;

    //        return c;
//    }
//
//    static void say_hello(String name, int age){
//        System.out.println("Hello~" + name + "I'm" + age + "years old");
//    }

    static int get_minus_cnt(int[] arr){
        // 파라미터로 넘어온 배열에서, 음수의 갯수를 카운팅하여 리턴한다.
        int minus_cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                minus_cnt = minus_cnt + 1;
            }
        }
        return minus_cnt;
    }

    public static void main (String[]args) {

        int[] arr = {5, 7, -23, -1, -99, 321, -99};
        int ret =  get_minus_cnt(arr);
        System.out.println("minus cnt is : " + ret);
    }
}

//       4. 숫자 2개를 함수입력받으면, 앞의 숫자에 뒤의 숫자 승을 하여, 결과를 리턴하는 함수를 만드세요.
//        System.out.println(get_pow(2,3));


//    과일등급구하기
//    String ret = get_fruti_grade(21);
//            System.out.println(ret);


////    2-2. 숫자5(다섯번)를 입력하여, 위의 함수를 호출합니다.
//        say_hello_cnt(5);

//    // 1-2. 3개의 숫자 345, 6783, 12345 의 평균을 구해서, 출력하세요.
//    double ret = get_average(345, 6783, 12345);
//        System.out.println(ret);

//            say_hello("Mike",30);
//
//    }

//        say_hello("hajni");
//        say_hello("hankikab");
//        say_hello("kikab hajin");
//        System.out.println(add(6,7));// 13으로 대체
//
//    }
//        int ret = add(3,4);// 7로 대체
//        System.out.println(ret);
//        }


//        int [][] arr = new int [2][3];
//        for(int i = 0; i < 2; i++){
//            for(int j = 0; j < 3; j++){
//                arr[i][j] = 10;
//            }
//            System.out.println();
//        }

//반이 7개, 각반마다 15명.
// 각 학생들의 수학평균점수 ( ex. 97.3점 ) 저장하려한다.
//        double[][] average_score_arr = new double[7][15];
//        int [][] score_arr = new int[20][3];
//        int[][] cart_arr = new int[100][25];
//        short[][][] image_arr = new short[100][100][3];
//        int [][][] student_score_arr = new int[20][3][2];

//        int [] student_score_arr = new int[100];
//
//
//        for(int i = 0; i < student_score_arr.length ; i++){
//            student_score_arr[i] = 50;
//        }
//        System.out.println(student_score_arr[5]);

//        // 0부터 100까지의 짝수의 합을 구하시오.
//        int sum = 0;
//        //      1        2 5 8        4 7
//        for(int i = 0; i <= 100; i  = i + 2){
//            //   3 6 9
//            sum = sum + i;
//        }
//        System.out.println("sum is :" + sum);
//
//        int sum2 = 0;
//
//        int i = 2;
//        while (i <= 100){
//            sum2 = sum2 + i;
//            i = i + 2;
//        }
//        System.out.println("sum2 is :" + sum2);


//        int score = 78;
//        if(score > 100 || score < 0){
//            System.out.println("Input correct Number!");
//        }else if(score >= 90) {
//            System.out.println("A grade");
//        }else  if(score == 80){
//            System.out.println("B Grade");
//        }else if(score == 77){
//            System.out.println("Lucky Number!");
//        }else{
//            System.out.println("F Grade");
//        }

//        boolean isAlien = true;
//
//        if(isAlien == false){
//            System.out.println("It is not an alien");
//        }else{
//            System.out.println("It is an alien");
//        }
//
//        int score = 80;
//        if(score < 100 && score >= 90){
//            System.out.println("A grade");
//        }else if(score >= 80){
//            System.out.println("B grade");
//        }else  if(score >= 70){
//            System.out.println("C grade");
//        }else {
//            System.out.println("F grade");
//        }


