package com.hajni.youtube2.model;

public class Youtube {


    public String title;
    public String description;
    public String mediumUrl;
    public String highUrl;
    public String videoId;

    public Youtube(){

    }
    public Youtube(String title, String description, String mediumUrl, String highUrl,String videoId) {

        this.title = title;
        this.description = description;
        this.mediumUrl = mediumUrl;
        this.highUrl = highUrl;
        this.videoId = videoId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getHighUrl() {
        return highUrl;
    }

    public void setHighUrl(String highUrl) {
        this.highUrl = highUrl;
    }
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
