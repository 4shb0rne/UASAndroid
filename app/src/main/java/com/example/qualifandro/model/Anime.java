package com.example.qualifandro.model;

public class Anime {
    private String name, image;
    private int episodes;
    private double rating;

    public Anime(){

    }

    public Anime(String name, String image, int episodes, double rating) {
        this.name = name;
        this.image = image;
        this.episodes = episodes;
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public double getRating() {
        return rating;
    }
}
