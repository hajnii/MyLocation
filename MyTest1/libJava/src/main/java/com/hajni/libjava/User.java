package com.hajni.libjava;

public class User {
    static int cal(int value1, int value2, String operator) {
        int ret = 0;
        if (operator.compareTo("add") == 0){
            ret = value1 + value2;
        }else if (operator.compareTo("mul") == 0){
            ret =  value1 * value2;
        }
        return ret;
    }


    static int[] get_arr(int number){
        int [] ret = new int[number];
        //ret = {0,0,0,0,0}
        for (int i = 0; i < number; i++){
            ret[i] = i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] my_arr = get_arr(5);
        for (int i = 0; i < my_arr.length; i++){
            System.out.println(my_arr[i]);
        }

        System.out.println(cal(3,4,"add"));

    }

}
//    private String email;
//    private String passwd;
//    public String nickname;
//
//
//    User(String nickname){
//        this.nickname = nickname;
//    }
//
//    boolean setEmail(String email) {
//        if (email.contains("@")){
//            this.email = email;
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    boolean setPasswd(String passwd,String passwd2) {
//        if (passwd.compareTo(passwd2) == 0){
//            if (passwd.length() < 6 || passwd.length() > 12){
//                return false;
//            }else {
//                this.passwd = passwd2;
//                return true;
//
//            }
//        }else {
//            return false;
//        }
//    }
//
//    void print(){
//        System.out.println("email : " + email);
//        System.out.println("passwd : " + passwd);
//        System.out.println("nickname : " + nickname);
//    }