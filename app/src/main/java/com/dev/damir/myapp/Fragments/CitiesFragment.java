package com.dev.damir.myapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Citiies.JSONDownloaderCities;
import com.dev.damir.myapp.R;


public class CitiesFragment extends Fragment {
    RecyclerView rv_cities;
    String jsonURL4 = "http://www.developer92.16mb.com/mentor/public_html/?page=all_cities";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cities, null);
        rv_cities = (RecyclerView) rootView.findViewById(R.id.rv_cities);
        rv_cities.setLayoutManager(new LinearLayoutManager(getActivity()));
        new JSONDownloaderCities(getActivity(), jsonURL4, rv_cities).execute();
        return rootView;
    }
}
