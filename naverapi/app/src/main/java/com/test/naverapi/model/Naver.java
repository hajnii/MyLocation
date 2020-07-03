package com.test.naverapi.model;

public class Naver {

    public String getTitle;
    public String getData;

    public Naver(){

    }

    public Naver(String getTitle, String getData) {
        this.getTitle = getTitle;
        this.getData = getData;
    }

    public String getGetTitle() {
        return getTitle;
    }

    public void setGetTitle(String getTitle) {
        this.getTitle = getTitle;
    }

    public String getGetData() {
        return getData;
    }

    public void setGetData(String getData) {
        this.getData = getData;
    }
}
