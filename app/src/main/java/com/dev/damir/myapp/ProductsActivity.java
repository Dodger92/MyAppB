package com.dev.damir.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dev.damir.myapp.Basket.BasketFragment;
import com.dev.damir.myapp.Products.JSONDownloaderProducts;

public class ProductsActivity extends AppCompatActivity {
    String jsonURL2;
    RecyclerView rv_products;
    Button btnBskt;
    ImageView basket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent getIntent= getIntent();
        String id= getIntent.getStringExtra("id");
        jsonURL2 = "http://deliveryking.kz/mobile_api/public_html/?page=all_products&id="+id;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Список товаров");
         basket=(ImageView)findViewById(R.id.basket);
        setSupportActionBar(toolbar);
        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        rv_products.setLayoutManager(new LinearLayoutManager(this));
        new JSONDownloaderProducts(this, jsonURL2, rv_products).execute();
basket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(ProductsActivity.this, BasketFragment.class);
        startActivity(intent);
    }
});
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

