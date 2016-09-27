package com.dev.damir.myapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.damir.myapp.Companies.m_JSON.JSONDownloader;
import com.dev.damir.myapp.R;


public class CompanyFragment extends Fragment {

    String jsonURL="http://developer92.16mb.com/mentor/public_html/?page=all_companies";
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.company_fragment,null);
        lv = (ListView) rootView.findViewById(R.id.lv);
        new JSONDownloader(getActivity(),jsonURL, lv).execute();
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar);
//        toolbar.setTitle("Компании");
        return rootView;
    }

}
