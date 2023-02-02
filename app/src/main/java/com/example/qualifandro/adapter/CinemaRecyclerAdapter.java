package com.example.qualifandro.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qualifandro.R;
import com.example.qualifandro.fragment.BookingFragment;
import com.example.qualifandro.fragment.BookingListFragment;
import com.example.qualifandro.fragment.MapFragment;
import com.example.qualifandro.model.Anime;
import com.example.qualifandro.model.Cinema;
import com.example.qualifandro.utility.RecyclerListener;

import java.util.ArrayList;

public class CinemaRecyclerAdapter extends RecyclerView.Adapter<CinemaRecyclerAdapter.ViewHolder>{
    private ArrayList<Cinema> cinemas;
    private RecyclerListener listener;

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public CinemaRecyclerAdapter(RecyclerListener listener) {
        this.cinemas = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CinemaRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema, parent, false);

        return new CinemaRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaRecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cinema cinema = cinemas.get(position);
        holder.cinemaName.setText(cinemas.get(position).getName());
        Bundle bundle = new Bundle();
        bundle.putString("name", cinema.getName());
        bundle.putDouble("latitude", cinema.getLatitude());
        bundle.putDouble("longitude", cinema.getLongitude());
        holder.mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapFragment fragment = new MapFragment();
                fragment.setArguments(bundle);
                listener.onButtonClick(fragment);
            }
        });
        holder.bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingFragment fragment = new BookingFragment();
                fragment.setArguments(bundle);
                listener.onButtonClick(fragment);
            }
        });
        holder.listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingListFragment fragment = new BookingListFragment();
                fragment.setArguments(bundle);
                listener.onButtonClick(fragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cinemas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cinemaName;
        Button mapBtn, bookBtn, listBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cinemaName = itemView.findViewById(R.id.cinema_name);
            mapBtn = itemView.findViewById(R.id.map_btn);
            bookBtn = itemView.findViewById(R.id.book_btn);
            listBtn = itemView.findViewById(R.id.book_list_btn);
        }
    }
}
