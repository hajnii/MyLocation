package com.hajni.libjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MyClass {

    static boolean checkEmail(String email){
        if (email.indexOf("@") == -1){
            return false;
        }else {
            return true;
        }
    }

    static boolean checkEmail2(String email){
        if (email.contains("@")){
            return true;
        }else {
            return false;
        }
    }

    static boolean checkpass(String pas1,String pas2){
        if (pas1.compareTo(pas2) == 0){
            if (pas1.length() <= 6 || pas1.length() > 12){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }


//    boolean  = true & false
    public static void main(String[] args) {

//        Member user1 = new Member("Mike","aaa");
//        Member user2 = new Member("Paul","bbb");
//
//        System.out.println(user1.name);
//        System.out.println(user1.id);


//        System.out.println("a");
//        int sum = 0;
//
//        for(int i = 0; i < 100; i++){
//            if (i % 3 == 0){
//                sum = sum + i;
//            }
//        }
//        System.out.println(sum);
//
//        while (true){
//        int a = (int)(Math.random() * 6)+ 1;
//        int b = (int)(Math.random() * 6)+ 1;
//        System.out.println("(" + a + "," + b + ")");
//            if (a + b == 5){
//                break;
//            }
//        }
//
//        for (int x = 0; x <= 10; x++){
//            for (int y = 0; y <= 10; y++){
//                if ((4 * x) + (5 * y) == 60 ){
//                    System.out.println(x + "," + y);
//                }
//            }
//        }

//        String a = "";
//        for (int i = 0; i < 6; i++){
//            a = "*" + a;
//            System.out.println(a);
//        }

//        for (int i = 5; i <= 5; i++){
//            for(int j = 0; j <= i ; j++){
//                System.out.println("*");
//            }
//            System.out.println("");
//        }
//        int speed = 29;
//            if (speed >= 1 && speed <= 3){
//                System.out.println("Light air");
//            }else if (speed >= 4 && speed <= 27){
//                System.out.println("Breeze");
//            }else if (speed >= 28 && speed <= 47) {
//                System.out.println("Gale");
//            }else {
//                System.out.println("Storm");
//            }

//        int a= 8;
//        if( a % 2 == 0){
//            System.out.println("Even");
//        }else {
//            System.out.println("Odd");
//        }
//        System.out.println();


//        String email = "12213@naver.com";
//        checkEmail(email);//호출
//        System.out.println(checkEmail(email));
//
//        String pas1 = "12345";
//        String pas2 = "123456";
//        System.out.println(checkpass(pas1,pas2));
//
//        User user1 = new User("mike");
//
//        user1.setEmail("12213@naver.comc");
//        user1.setPasswd("203468@aa","203468@aa");
//
//        user1.print();

        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());

        list.add("400");
        list.add("java");
        list.add("abc");
        System.out.println(list.size());
        list.add(1,"python");

        System.out.println("-------------------");
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        list.remove(0);
        System.out.println("-------------------");
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }

        // 1, loop
        list.remove("abc");
        System.out.println("-------------------");
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }

        list.add("Hello");
        list.add("Bye");
        list.add("Welcome to this Java Class");

        // 2, loop
        System.out.println("----------------");
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        //3, loop
        System.out.println("----------------");
        for (String value : list){
            System.out.println(value);
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "Mike");
        map.put("tel", "010-1234-5678");
        map.put("address", "Seoul");
        map.put("name", "Paul");// 중복값일경우 마지막입력으로 변경;
        map.put("name", "Jane");
        map.put("age", "25");

        System.out.println(map.get("name"));
        System.out.println(map.get("tel"));
        System.out.println(map.get("address"));

        System.out.println("----------------");
        Object[] keys = map.keySet().toArray();
        for (int k = 0; k < keys.length; k++){
            System.out.println((String)keys[k]);
        }
        System.out.println("----------------");

        Object[] values = map.values().toArray();
        for (int k = 0; k < values.length; k++){
            System.out.println((String)values[k]);
        }
        System.out.println("----------------");

        // "KOR" , 88       "ENG" , 77      "MATH"  : 100
        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("KOR", 88);
        scoreMap.put("ENG", 77);
        scoreMap.put("MATH", 100);

        Object[] values2 = scoreMap.values().toArray();
        for (int k = 0; k < values2.length; k++){
            System.out.println((Integer) values2[k]);
        }

        System.out.println("----------------");

        // ArrayList 에 점수 저장.
        // 46.33, 77.8 , 90.0 , 87.5
        ArrayList<Double> scoreList = new ArrayList<>();
        scoreList.add(46.33);
        scoreList.add(77.8);
        scoreList.add(90.0);
        scoreList.add(87.5);
        for (Double value : scoreList){
            System.out.println(value);
        }
        System.out.println("----------------");

        // "Mike" 46.33, "Harry" 77.8 , "Jane" 90.0 , "Paul" 87.5
        HashMap<String, Double> nameMap = new HashMap<>();
        nameMap.put("Mike", 46.33);
        nameMap.put("Harry", 77.8);
        nameMap.put("Jane", 90.0);
        nameMap.put("Paul", 87.5);

        System.out.println(nameMap.get("Jane"));

        nameMap.remove("Jane");

        System.out.println(nameMap.get("Jane"));

//        Object[] values3 = nameMap.values().toArray();
//        for (int k = 0; k < values3.length; k++){
//            System.out.println((Integer) values3[k]);
//        }



    }
}


