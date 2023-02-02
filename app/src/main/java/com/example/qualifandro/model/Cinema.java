package com.example.qualifandro.model;

import java.util.ArrayList;

public class Cinema {
    private String name;
    private double latitude, longitude;
    private ArrayList<Booking> bookings;

    public Cinema(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
