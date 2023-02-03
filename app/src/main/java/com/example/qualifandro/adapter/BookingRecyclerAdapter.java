package com.example.qualifandro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.qualifandro.R;
import com.example.qualifandro.model.Booking;

import java.util.ArrayList;

public class BookingRecyclerAdapter extends RecyclerView.Adapter<BookingRecyclerAdapter.ViewHolder>{
    private ArrayList<Booking> bookings;

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public BookingRecyclerAdapter(){
        bookings = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);

        return new BookingRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookingUserName.setText(bookings.get(position).getUsername());
        holder.bookingMovieName.setText(bookings.get(position).getAnimename());
        holder.bookingStudioName.setText(bookings.get(position).getStudioName());
        Glide.with(holder.itemView).load(bookings.get(position).getImage()).into(holder.bookingImage);
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookingMovieName, bookingUserName, bookingStudioName;
        ImageView bookingImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookingMovieName = itemView.findViewById(R.id.booking_movie_name);
            bookingUserName = itemView.findViewById(R.id.booking_user_name);
            bookingImage = itemView.findViewById(R.id.booking_img);
            bookingStudioName = itemView.findViewById(R.id.booking_studio);
        }
    }
}
