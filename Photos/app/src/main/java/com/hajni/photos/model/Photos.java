package com.hajni.photos.model;

public class Photos {
    private int albumld;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photos(){

    }

    public Photos(int albumld,int id,String title,String url,String thumbnailUrl){

        this.albumld = albumld;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumld() {
        return albumld;
    }

    public void setAlbumld(int albumld) {
        this.albumld = albumld;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
