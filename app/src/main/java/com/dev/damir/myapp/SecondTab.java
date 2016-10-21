package com.dev.damir.myapp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dev.damir.myapp.Actions.JSONDownloaderActions;
import com.dev.damir.myapp.api_classes.SharedPreference;
public class SecondTab extends Fragment {
    String jsonURL3;
    RecyclerView rv_actions;
    TextView companyName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_tab,null);
        //companyName=(TextView)rootView.findViewById(R.id.companyTxt);
        jsonURL3= "http://deliveryking.kz/mobile_api/public_html/?page=all_actions&id="+ SharedPreference.getCityId(getContext());
        rv_actions = (RecyclerView) rootView.findViewById(R.id.rv_actions);
        rv_actions.setLayoutManager(new LinearLayoutManager(getActivity()));
        new JSONDownloaderActions(getActivity(), jsonURL3, rv_actions).execute();
//        companyName.setText(SharedPreference.getCompanyName(getActivity()));
        return rootView;
    }
}
