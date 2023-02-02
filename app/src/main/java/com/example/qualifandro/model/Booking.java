package com.example.qualifandro.model;

public class Booking {
    private String username, animename, image;

    public Booking(String username, String animename, String image) {
        this.username = username;
        this.animename = animename;
        this.image = image;
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
