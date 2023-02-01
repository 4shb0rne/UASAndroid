package com.example.qualifandro.utility;

import android.util.Log;
import android.widget.Toast;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.qualifandro.adapter.AnimeRecyclerAdapter;
import com.example.qualifandro.database.AnimeTable;
import com.example.qualifandro.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APIManager {
    private Context ctx;
    private RequestQueue queue;
    private RecyclerView rvAnime;
    public String url = "https://api.jikan.moe/v4/top/anime";
    private AnimeRecyclerAdapter cra;
    public APIManager(Context ctx, AnimeRecyclerAdapter cra,RecyclerView rv){
        this.ctx = ctx;
        this.queue = Volley.newRequestQueue(ctx);
        this.cra = cra;
        this.rvAnime = rv;
    }

    public void fetchData(){
        AnimeTable table = AnimeTable.getInstance();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET , url, null, response -> {
            try {
                JSONArray records = response.getJSONArray("data");
                if(table.getAllAnimes().size() == 0){
                    for(int i = 0 ; i < records.length() ; i++){
                        try {
                            JSONObject temp = records.getJSONObject(i);
                            String name = temp.getString("title");
                            String image = temp.getJSONObject("images").getJSONObject("jpg").getString("image_url");
                            double rating = temp.getDouble("score");
                            int episodes = temp.getInt("episodes");
                            table.insertAnime(new Anime(name, image, episodes, rating));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                cra = new AnimeRecyclerAdapter(ctx);
                cra.setCakes(table.getAllAnimes());
                cra.notifyDataSetChanged();
                rvAnime.setAdapter(cra);
                rvAnime.setLayoutManager(new LinearLayoutManager(ctx));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Log.d("ERROR", "fetchData: error"));
        queue.add(req);
    }
}
