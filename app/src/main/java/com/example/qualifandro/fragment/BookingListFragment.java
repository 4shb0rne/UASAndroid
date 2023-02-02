package com.example.qualifandro.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qualifandro.R;
import com.example.qualifandro.adapter.BookingRecyclerAdapter;
import com.example.qualifandro.DataStorage.CinemaList;
import com.example.qualifandro.model.Cinema;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rvBooking;
    private CinemaList cinemaList;
    private TextView errorMsg;
    private BookingRecyclerAdapter bra;


    public BookingListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingListFragment newInstance(String param1, String param2) {
        BookingListFragment fragment = new BookingListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_list, container, false);
        rvBooking = view.findViewById(R.id.rv_booking_list);
        errorMsg = view.findViewById(R.id.empty_message);
        cinemaList = CinemaList.getInstance();
        bra = new BookingRecyclerAdapter();
        Bundle args = getArguments();
        String name = args.getString("name");
        for(Cinema cinema : cinemaList.getAllCinemas()){
            if(cinema.getName().equals(name)){
                bra.setBookings(cinema.getBookings());
                if(cinema.getBookings().isEmpty()){
                    errorMsg.setVisibility(View.VISIBLE);
                }
            }
        }
        bra.notifyDataSetChanged();
        rvBooking.setAdapter(bra);
        rvBooking.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return view;
    }
}