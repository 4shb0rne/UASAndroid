package com.example.qualifandro.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.qualifandro.R;
import com.example.qualifandro.database.AnimeTable;
import com.example.qualifandro.database.CinemaList;
import com.example.qualifandro.model.Anime;
import com.example.qualifandro.model.Booking;
import com.example.qualifandro.model.Cinema;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView currentCinema, errorTxt;
    private String name, rent;
    private Double latitude, longitude;
    private Spinner spin;
    private Button rentBtn;
    private EditText renterName;
    public BookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
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
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        Bundle args = getArguments();
        CinemaList cinemaList = CinemaList.getInstance();
        AnimeTable animeTable = AnimeTable.getInstance();
        name = args.getString("name");
        longitude = args.getDouble("longitude");
        latitude = args.getDouble("latitude");
        errorTxt = view.findViewById(R.id.renting_error);
        rentBtn = view.findViewById(R.id.btn_rent);
        spin = view.findViewById(R.id.anime_spinners);
        spin.setOnItemSelectedListener(this);
        renterName = view.findViewById(R.id.txt_renter_name);
        ArrayList<String> animeNames = new ArrayList<>();
        ArrayList<String> animeImages = new ArrayList<>();
        for(Anime anime : animeTable.getAllAnimes()){
            animeNames.add(anime.getName());
            animeImages.add(anime.getImage());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, animeNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        currentCinema = view.findViewById(R.id.cinema_txt);
        currentCinema.setText("Chosen Cinema : " + name);

        rentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInput()){
                    int idx = 0;
                    errorTxt.setVisibility(View.GONE);
                    String animeTitle = spin.getSelectedItem().toString();
                    for(int i = 0; i < cinemaList.getAllCinemas().size(); i++){
                        if(cinemaList.getAllCinemas().get(i).getName().equals(name)){
                            idx = i;
                        }
                    }
                    for(Anime anime : animeTable.getAllAnimes()){
                        if(anime.getName().equals(animeTitle)){
                            cinemaList.getAllCinemas().get(idx).getBookings().add(new Booking("Penyewa : " + rent, animeTitle,
                                    anime.getImage()));
                        }
                    }
                    replaceFragment(new CinemaFragment());
                } else {
                    errorTxt.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {}

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    private boolean validateInput() {
        rent = renterName.getText().toString();
        if(rent.length() == 0){
            return false;
        }
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
        );
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}