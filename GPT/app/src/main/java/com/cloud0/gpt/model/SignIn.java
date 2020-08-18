package com.cloud0.gpt.model;

public class SignIn {
    private String document;
    private String userId ;
    private String password;

    public SignIn(){

    }

    public SignIn(String userId, String password) {

        this.userId = userId;
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
