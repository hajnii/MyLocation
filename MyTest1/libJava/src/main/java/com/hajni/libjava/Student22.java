package com.hajni.libjava;

public class Student22 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    double average;

    void sum() {
        sum = kor + eng + math;
    }

    void avg() {
        average = (double) sum / 3;
    }

    void print() {
        System.out.println(name + ", " + sum + ", " + average);
    }

    int get_score(int a) {
        int ret = kor * a;
        return ret;
    }

    String get_avg(int i) {
        if (average > i) {
            return "A Grade";
        } else {
            return "F Grade";
        }
    }
}

    // 숫자 하나를 입력받으면, 해당 숫자를 kor이랑 곱한 후, 리턴하는
    // 메소드를 만드세요.

//      하진이 푼거
//    static int number_sum(int a){
//        a = kor * a;
//        return a;
//    }
//String get_avg(int i) {
//    if (average > i) {
//        System.out.println("A Grade");
//    } else {
//        System.out.println("F Grade");
//    }
//}



//    Student a = new Student();
//    Student a2 = new Student();
//
//        a.name = "Mike";
//                a.kor = 90;
//                a.eng = 95;
//                a.math = 85;
//                a.sum = a.kor + a.eng + a.math;
//                a.average = (double)a.sum / 3;
//
//
//                a2.name = "Paul";
//                a2.kor = 80;
//                a2.eng = 98;
//                a2.math = 91;
//                a2.sum = a2.kor + a2.eng + a2.math;
//                a2.average = (double)a2.sum / 3;
//
//                System.out.println(a.name +", sum : "+ a.sum +", avg : "+ a.average);
//                System.out.println(a2.name +", sum : "+ a2.sum +", avg : "+ a2.average);
//
//// 첫번재 사람의 이름, 총점, 평균 : Mike sum : 723 , avg : 67.123
//// 두번째 사람의 이름, 총점, 펴균