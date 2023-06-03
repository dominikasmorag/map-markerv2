package com.dominika.springbootapp.pojo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
    private double lat;
    private double lon;

    public Position() {
    }

    public Position(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }


}
