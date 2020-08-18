package com.test.myfriends.model;

import java.io.Serializable;

public class Data implements Serializable {

    public String id;
    public String name;
    public String phone;

    public Data(){

    }
    public Data(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Data(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
