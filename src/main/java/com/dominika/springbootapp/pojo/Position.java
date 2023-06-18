package com.dominika.springbootapp.pojo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
    private String lat;
    private String lon;

    public Position() {
    }

    public Position(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
