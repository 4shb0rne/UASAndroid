package com.example.qualifandro.model;

public class Booking {
    private String username, animename, image, studioName;

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public Booking(String username, String animename, String image,
                   String studioName) {
        this.username = username;
        this.animename = animename;
        this.image = image;
        this.studioName = studioName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnimename() {
        return animename;
    }

    public void setAnimename(String animename) {
        this.animename = animename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
