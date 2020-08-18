package com.hajni.libjava;
            //클래스이름
public class MemberX {
    //멤버 변수
    String name;
    String tel;
    String address;

    MemberX(String name, String tel, String address){
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    //생성자 : 생성자는 클래스 이름과 동일하게 지을것.
    MemberX(){
        name = "no name";
        tel = "no tel";
        address = "no address";
    }
    //메소드
    void print(){
        System.out.println("name : "+ name);
        System.out.println("tel : "+ tel);
        System.out.println("address : "+ address);
    }

}
