package com.test.mylocation.data;

public class Store {

    private double lat;
    private double lng;
    private String id;
    private String name;
    private String vicinity;

    public Store(){

    }

    public Store(double lat, double lng, String id, String name, String vicinity) {
        this.lat = lat;
        this.lng = lng;
        this.id = id;
        this.name = name;
        this.vicinity = vicinity;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
