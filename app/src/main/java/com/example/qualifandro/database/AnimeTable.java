package com.example.qualifandro.database;

import com.example.qualifandro.model.Anime;
import com.example.qualifandro.utility.APIManager;

import java.util.ArrayList;

public class AnimeTable {
    private static AnimeTable instance;
    public static ArrayList<Anime> animes;
    private AnimeTable() {
        animes = new ArrayList<>();
    }

    public static AnimeTable getInstance(){
        if(animes == null){
            instance = new AnimeTable();
        }
        return instance;
    }

    public ArrayList<Anime> getAllAnimes(){
        return animes;
    }

    public void insertAnime(Anime anime){
        animes.add(anime);
    }

}
