package com.dev.damir.myapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dev.damir.myapp.Actions.JSONDownloaderActions;
import com.dev.damir.myapp.R;


public class ActionFragment  extends AppCompatActivity{
    String jsonURL3;
    RecyclerView rv_actions;
    Toolbar toolbar;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_tab);
        Intent getIntent= getIntent();
        String id= getIntent.getStringExtra("id");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Список акций");
        setSupportActionBar(toolbar);
        jsonURL3= "http://developer92.16mb.com/mentor/public_html/?page=all_actions&id="+id;
        rv_actions = (RecyclerView) findViewById(R.id.rv_actions);
        rv_actions.setLayoutManager(new LinearLayoutManager(this));
        new JSONDownloaderActions(this, jsonURL3, rv_actions).execute();
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










/*Fragment {
    String jsonURL3;
    RecyclerView rv_actions;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_tab,null);
        Intent getIntent= getActivity().getIntent();
        String id= getIntent.getStringExtra("id");
        jsonURL3= "http://developer92.16mb.com/mentor/public_html/?page=all_actions&id="+id;
        rv_actions = (RecyclerView) rootView.findViewById(R.id.rv_actions);
        rv_actions.setLayoutManager(new LinearLayoutManager(getActivity()));
        new JSONDownloaderActions(getActivity(), jsonURL3, rv_actions).execute();
        return rootView;
    }
}
*/