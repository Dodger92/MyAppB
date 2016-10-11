package com.dev.damir.myapp.Citiies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dev.damir.myapp.MainActivity;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.api_classes.SharedPreference;

import java.util.ArrayList;

public class MyAdapterCities extends RecyclerView.Adapter<MyViewHolderCities> {

    Context c;
    ArrayList<City> cities;
    Toast toast;

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
                openFirstTab(id, name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    private void openFirstTab(String id, String name) {
        Intent intent = new Intent(c, MainActivity.class);
        intent.putExtra("id", id);
        SharedPreference.setCityId(c, id);
        SharedPreference.setCityNameValue(c, name);
        toast.makeText(c, "Выбран город: " + name, Toast.LENGTH_SHORT).show();
        c.startActivity(intent);
    }
}

