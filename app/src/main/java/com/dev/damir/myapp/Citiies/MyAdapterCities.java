package com.dev.damir.myapp.Citiies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.FirstTab;
import com.dev.damir.myapp.R;

import java.util.ArrayList;

public class MyAdapterCities extends RecyclerView.Adapter<MyViewHolderCities> {

    Context c;
    ArrayList<City> cities;

    public MyAdapterCities(Context c, ArrayList<City> cities) {
        this.c = c;
        this.cities = cities;
    }

    @Override
    public MyViewHolderCities onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model_city, parent, false);
        return new MyViewHolderCities(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolderCities holder, int position) {

        City city = cities.get(position);
        final String name = city.getName();
        final String id = city.getId();

        //BIND
        holder.nameTxt.setText(name);
        holder.idTxt.setText(id);
        holder.setItemClickListenerCities(new ItemClickListenerCities() {
            @Override
            public void onItemClick(int pos) {
                openFirstTab(id);
            }
        });
    }
    @Override
    public int getItemCount() {
        return cities.size();
    }
    private void openFirstTab(String id){
        Intent intent=new Intent(c, FirstTab.class);
        intent.putExtra("id",id);
        c.startActivity(intent);
    }
    }

