package com.hajni.libjava;

public class tast200511 {

//    static int add(int x, int y, int z){
//        int sum = x + y + z;
//        return sum;
//    }
//    // return 이 없으면 void(없다 ,return이 없다)
//    static void  say(int x){
//        int z = x * 100;
//    }

    public static void main(String[] args) {

        int a = 2;
        switch (a){
            case 1:
                System.out.println("hello");
                break;
            case 2:
                System.out.println("Cat");
                break;
            case 3:
                System.out.println("Dog");
                break;
            default:
                System.out.println("Nothing");
                break;
        }

        //void
//        int ret = add(3,4,5);
//        add(3,4,5);
//        System.out.println(ret);



        // for,while 사용할 때
        // 1. 횟수 => for / while
        // 2. 데이터를 많이 저장하는것(배열 , , , , , , ) 작업 => for / while
        // 3. 반복되는 패턴 => for / while
        // -----------------------------------------------------------------
        //  체크할때는 항상 if
        //          for문의 cpu처리순서
        //           int sum = 0;
        //            for(int i = 5; i <= 60; i++){
        //
        //                if (i % 2 == 0) {
        //                    sum = sum + i;
        //                }
        //            }System.out.println(sum);

        //        int[] coding_score_arr = {34, 66, 32, 77, 45, 79, 88, 97};
        //        for (int i = 0; i < 8 ; i++) {
        //            coding_score_arr[i] = coding_score_arr[i] + 3;
        //        }
        //
        //        for (int i = 0; i < 8 ; i++){
        //            System.out.println(coding_score_arr[i]);

        //배열
        //        int[] coding_score_arr = {34, 66, 32, 77, 45, 79, 88, 97};
        //
        //        for(int i = 0; i < coding_score_arr.length; i++){
        //            System.out.println(coding_score_arr[i]);
        //        }

        //        int len = coding_score_arr.length;
        //        System.out.println(len);
        //
        //
        //        int[] some_arr = new int[2131];
        //        len = some_arr.length;//or System.out.println(some_arr.length)

    }
}
