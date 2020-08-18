package com.test.naverapi.model;

public class Translation {

    private int id ;
    private String srcLangType;
    private String tarLangType;
    private String translatedText;
    private String inputTxt;

    public Translation(){

    }

    public Translation(String srcLangType, String tarLangType, String translatedText,String inputTxt) {
        this.srcLangType = srcLangType;
        this.tarLangType = tarLangType;
        this.translatedText = translatedText;
        this.inputTxt = inputTxt;
    }

    public Translation(int id, String srcLangType, String tarLangType, String translatedText, String inputTxt) {
        this.id = id;
        this.srcLangType = srcLangType;
        this.tarLangType = tarLangType;
        this.translatedText = translatedText;
        this.inputTxt = inputTxt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputTxt() {
        return inputTxt;
    }

    public void setInputTxt(String inputTxt) {
        this.inputTxt = inputTxt;
    }

    public String getSrcLangType() {
        return srcLangType;
    }

    public void setSrcLangType(String srcLangType) {
        this.srcLangType = srcLangType;
    }

    public String getTarLangType() {
        return tarLangType;
    }

    public void setTarLangType(String tarLangType) {
        this.tarLangType = tarLangType;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
