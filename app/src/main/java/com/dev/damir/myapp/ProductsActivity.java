package com.dev.damir.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.dev.damir.myapp.Products.JSONDownloaderProducts;

public class ProductsActivity extends AppCompatActivity {
    String jsonURL2;
    RecyclerView rv_products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent getIntent= getIntent();
        String id= getIntent.getStringExtra("id");
        jsonURL2 = "http://developer92.16mb.com/mentor/public_html/?page=all_products&id="+id;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Список товаров");
        setSupportActionBar(toolbar);
        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        rv_products.setLayoutManager(new LinearLayoutManager(this));

        new JSONDownloaderProducts(this, jsonURL2, rv_products).execute();
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

