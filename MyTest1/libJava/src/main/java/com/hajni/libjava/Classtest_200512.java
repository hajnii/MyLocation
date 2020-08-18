package com.hajni.libjava;

public class Classtest_200512 {
    public static void main(String[] args) {
        Student22 a = new Student22();
        Student22 a2 = new Student22();
        a.name = "Mike";
        a.kor = 90;
        a.eng = 80;
        a.math = 77;
        a.sum();
        a.avg();
        a.print();
        System.out.println(a.get_score(8));
        String grade = (a.get_avg(90));
        System.out.println(grade);
        // = System.out.println(a.get_avg(90);


        // 정수를 입력받아서, 해당 정수보다 평균점수가 크면, "A Grade"리턴
        // 그렇지않으면, "F Grade"리턴

         // 첫번재 사람의 이름, 총점, 평균 : Mike sum : 723 , avg : 67.123
        // 두번째 사람의 이름, 총점, 펴균


//        Product p1 = new Product();
//        Product p2 = new Product();
//
//        p1.number = 1;
//        p1.name = "HAJNI";
//
//        p2.number = 2;
//        p2.name = "KIKAB";
//
//        p1.print();
//        p2.print();


//        Account c = new Account();
//
//        c.setMoney(1500);
//        c.setMoney(1500);
//        c.setMoney(8000);
//        System.out.println(c.getMoney(10000));
//        c.plint();
//        System.out.println(c.getMoney(1000));
//        c.plint();


    }
}
