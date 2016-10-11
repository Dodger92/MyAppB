package com.dev.damir.myapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dev.damir.myapp.Citiies.JSONDownloaderCities;
import com.dev.damir.myapp.R;


public class CitiesFragment extends AppCompatActivity {
    RecyclerView rv_cities;
    String jsonURL4 = "http://www.developer92.16mb.com/mentor/public_html/?page=all_cities";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Выберите город");
        setSupportActionBar(toolbar);
        rv_cities = (RecyclerView) findViewById(R.id.rv_cities);
        rv_cities.setLayoutManager(new LinearLayoutManager(this));
        new JSONDownloaderCities(this, jsonURL4, rv_cities).execute();
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    }





