package com.example.qualifandro.database;
import com.example.qualifandro.model.Cinema;

import java.util.ArrayList;

public class CinemaList {
    private static CinemaList instance;
    public static ArrayList<Cinema> cinemas;
    private CinemaList() {
        cinemas = new ArrayList<>();
        initCinemas();
    }

    public static CinemaList getInstance(){
        if(cinemas == null){
            instance = new CinemaList();
        }
        return instance;
    }

    private void initCinemas(){
        cinemas.add(new Cinema("Cinema CGP Alpha", -6.193924061113853,
                106.78813220277623));
        cinemas.add(new Cinema("Cinema CGP Beta", -6.20175020412279,
                106.78223868546155));
    }

    public ArrayList<Cinema> getAllCinemas(){
        return cinemas;
    }

    public void insertCinema(Cinema cinema){
        cinemas.add(cinema);
    }
}
