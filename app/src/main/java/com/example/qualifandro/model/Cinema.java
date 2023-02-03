package com.example.qualifandro.model;

import java.util.ArrayList;

public class Cinema {
    private String name;
    private double latitude, longitude;
    private ArrayList<Booking> bookings;
    private ArrayList<Studio> studios;

    public Cinema(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bookings = new ArrayList<>();
        initStudios();
    }

    private void initStudios(){
        studios = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            studios.add(new Studio("Studio " + (i+1), ""));
        }
    }

    public ArrayList<Studio> getStudios() {
        return studios;
    }

    public ArrayList<Studio> getAvailableStudios() {
        ArrayList<Studio> available = new ArrayList<>();
        for(Studio studio : studios){
            if(studio.getRenter().equals("")){
                available.add(studio);
            }
        }
        return available;
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
