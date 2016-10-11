package com.dev.damir.myapp.Products;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.dev.damir.myapp.R;

public class TestActivity extends Activity {
    TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Список покупок");
        tvView = (TextView) findViewById(R.id.TxtToBuy);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        tvView.setText("Товар : " + name + " " + price+" "+"тг");
    }
}
