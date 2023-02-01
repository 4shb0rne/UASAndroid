package com.example.qualifandro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.qualifandro.R;
import com.example.qualifandro.model.Anime;

import java.util.ArrayList;

public class AnimeRecyclerAdapter extends RecyclerView.Adapter<AnimeRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Anime> animes;

    public AnimeRecyclerAdapter(Context context) {
        this.context = context;
        this.animes = new ArrayList<>();
    }

    public void setCakes(ArrayList<Anime> animes) {
        this.animes = animes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);

        return new AnimeRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(animes.get(position).getName());
        Glide.with(holder.itemView).load(animes.get(position).getImage()).into(holder.tvImage);
        holder.tvEpisodes.setText(animes.get(position).getEpisodes() + " Episodes");
        holder.tvScore.setText("Rating : " + animes.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvEpisodes, tvScore;
        ImageView tvImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.anime_title);
            tvEpisodes = itemView.findViewById(R.id.anime_episodes);
            tvScore = itemView.findViewById(R.id.anime_score);
            tvImage = itemView.findViewById(R.id.anime_img);
        }
    }
}
