package com.example.qualifandro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qualifandro.R;
import com.example.qualifandro.model.Anime;
import com.example.qualifandro.model.Cinema;

import java.util.ArrayList;

public class CinemaRecyclerAdapter extends RecyclerView.Adapter<CinemaRecyclerAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Cinema> cinemas;

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @NonNull
    @Override
    public CinemaRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema, parent, false);

        return new CinemaRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaRecyclerAdapter.ViewHolder holder, int position) {
        holder.cinemaName.setText(cinemas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cinemas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cinemaName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cinemaName = itemView.findViewById(R.id.cinema_name);
        }
    }
}
