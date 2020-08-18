package com.hajni.libjava;

public class test_200512 {

    //return 예제
//    static int mul(int a, int b){
//        int c = a * b;
//        System.out.println("hello");
//        return c;

//      void 예제
//    static void some(int a, int b){
//        int c = a + b + 3;

    // 예제2
//    static int some(int a, int b){
//        int c = a * b + 3;
//        return c;
//    }


    //예제3
//    static int some(int a, int b){
//        int c = a * b + 3;
//        System.out.println(c);
//    }

    static String some(String name){
        String sentence = "Hello" + name;
        System.out.println(name);
        System.out.println("bye");// 1. cpu 가 여기까지 실행했을때, 화면출력과 메모리
        return sentence;
    }


    public static void main(String[] args) {
        System.out.println("This is Main");
        some("Mike");               // 2. cpu가 여기까지 실행했을때,
        String my_sentnce = some("Mike");
        System.out.println(my_sentnce);// 3. cpu가 여기까지 실행했을때,
        System.out.println(some("Mike")); // 4. cpu가 여기까지 실행했을때,
    }
}

    //예제3
//    public static void main(String[] args) {
//        int c = 7;
//        c = some(1,1) + 10;
//        System.out.println(c);  // 14

    //예제2
//    public static void main(String[] args) {
//        int c = 7;
//        System.out.println(some(1,1));
//        System.out.println(c);  // 7


        // return 예제
//        System.out.println("start");
//        int a = 4;
//        int b = 7;
//        int c = mul(a,b);
//        System.out.println(c);

//      //void 예제
//        public static void main(String[] args) {
//            int c = 7;
//            some(10,20);
//            System.out.println(c); // 7
