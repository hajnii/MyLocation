package com.hajni.libjava;

public class Product {
    int number;
    String name;

    void print(){
        System.out.println("number = " + number);
        System.out.println("name = " + name);
    }
}



//    public static void main(String[] args) {
//    Dog a = new Dog();
//    a.name = "Mike";
//    a.age = 1;
//
//    Dog a2 = new Dog();
//    a2.name = "paul";
//    a2.age = 2;
//
//    System.out.println(a.name +" "+ a.age);
//    System.out.println(a2.name +" "+ a2.age);
//    }
//    public static void main(String[] args) {
//        System.out.println("I am main");
//        int a = 10;
//        // class  <-> instance(object)
//         Product p = new Product();
//         p.number = 1;
//         p.name = "Monitor";
//
//         Product p2 = new Product();
//         p2.number = 2;
//         p2.name = "Keyboard";
//
//        System.out.println(p2.number);
//        System.out.println(p.number);
//        System.out.println(p.name);
//        System.out.println(p2.name);
//    }