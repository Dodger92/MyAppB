package com.dev.damir.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Actions.JSONDownloaderActions;


public class SecondTab extends Fragment {
    String jsonURL3 = "http://developer92.16mb.com/mentor/public_html/?page=all_actions";
    RecyclerView rv_actions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_tab, null);
       rv_actions= (RecyclerView) rootView.findViewById(R.id.rv_actions);
        rv_actions.setLayoutManager(new LinearLayoutManager(getActivity()));
        new JSONDownloaderActions(getActivity(), jsonURL3, rv_actions).execute();
        return rootView;
    }
}
