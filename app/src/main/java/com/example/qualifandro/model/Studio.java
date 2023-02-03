package com.example.qualifandro.model;

public class Studio {
    private String studioName, renter;

    public Studio(String studioName, String renter) {
        this.studioName = studioName;
        this.renter = renter;
    }

    public String getStudioName() {
        return studioName;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
}
