package com.example.qualifandro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qualifandro.adapter.AnimeRecyclerAdapter;
import com.example.qualifandro.database.AnimeTable;
import com.example.qualifandro.utility.APIManager;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeFullName;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if (item.getItemId() == R.id.it_logout) {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private RecyclerView rvCake;
    private AnimeTable cakeTable;
    private AnimeRecyclerAdapter cra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cakeTable = AnimeTable.getInstance();
        rvCake = findViewById(R.id.rv_animes);

        APIManager api = new APIManager(this, cra, rvCake);

        if(cakeTable.getAllAnimes().size() == 0){
            api.fetchData();
        }
    }
}