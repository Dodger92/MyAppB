package com.dev.damir.myapp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Companies_tab.m_JSON.JSONDownloader;
import com.dev.damir.myapp.api_classes.SharedPreference;
//Вывод компаний в первом табе
public class FirstTab extends Fragment {
    String jsonURL;
    RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.first_tab_fragment, null);
        jsonURL = "http://deliveryking.kz/mobile_api/public_html/?page=all_companies&id=" + SharedPreference.getCityId(getContext());
        rv = (RecyclerView) rootView.findViewById(R.id.rv);
        Log.d("myCity", SharedPreference.getCityId(getContext()));
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        new JSONDownloader(getActivity(), jsonURL, rv).execute();
        return rootView;
    }


}

