package com.dev.damir.myapp.Basket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.damir.myapp.Basket.DeleteBtn.JDBDelete;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.api_classes.SharedPreference;


public class BasketDetailActivity extends AppCompatActivity {
    TextView nameTxt, anonsTxt, priceTxt,idTxt;
    Button addToBasket, deleteBtn;
    String jsonURL10;
    Toast toast;
    //String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_detail);
        addToBasket=(Button)findViewById(R.id.addToBasket);
        deleteBtn =(Button)findViewById(R.id.deleteBtn);
        nameTxt = (TextView) findViewById(R.id.txt);
        anonsTxt = (TextView) findViewById(R.id.nameDetailTxt);
        priceTxt = (TextView) findViewById(R.id.priceDetailTxt);
        idTxt = (TextView) findViewById(R.id.idTxt);
        Intent i = this.getIntent();
        final String name = i.getExtras().getString("NAME_KEY");
        final String anons = i.getExtras().getString("ANONS_KEY");
        final String price = i.getExtras().getString("PRICE_KEY");
        final String id = i.getExtras().getString("PRICE_ID");
        nameTxt.setText(name);
        anonsTxt.setText(anons);
        priceTxt.setText(price);
        idTxt.setText(id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Подробнее о товаре");
        setSupportActionBar(toolbar);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonURL10 = "www.developer92.16mb.com/mentor/public_html/?page=delete_liked&id="+id;
                new JDBDelete(BasketDetailActivity.this, jsonURL10).execute();

            }
        });

        if (getSupportActionBar() != null) {
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
    private void AddNewBuy(String id) {
        //text=idTxt.getText().toString();
        SharedPreference.setBASKET(this,id);
    }
}
      /*  String name=i.getExtras().getString("NAME KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String username=i.getExtras().getString("USERNAME_KEY");
        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);*/


