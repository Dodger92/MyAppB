package com.dev.damir.myapp.Actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.dev.damir.myapp.R;
public class DetailActivityActions extends AppCompatActivity {
    TextView nameTxt, contentTxt;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_actions);
        nameTxt = (TextView) findViewById(R.id.nameDetailTxt);
        contentTxt = (TextView) findViewById(R.id.contentDetailTxt);
        Intent i = this.getIntent();
        String name = i.getExtras().getString("NAME_KEY");
        String content = i.getExtras().getString("CONTENT_KEY");
        nameTxt.setText(name);
        contentTxt.setText(content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Описание акции");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}

