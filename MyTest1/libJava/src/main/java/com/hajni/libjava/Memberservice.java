package com.hajni.libjava;

public class Memberservice {

    String id;
    String password;


    boolean login(String id,String password){
        if (id.compareTo("hong") == 0 && password.compareTo("12345") == 0){
            return true;
        }else {
            return false;
        }
    }

    void logout(String id){
        System.out.println("Logout");
    }

    public static void main(String[] args) {
        Memberservice memberService = new Memberservice();
        boolean result = memberService.login("hong","12345");
        if (result){
            System.out.println("Log in");
            memberService.logout("hong");
        }else {
            System.out.println("Not Correct.");
        }
    }
}
