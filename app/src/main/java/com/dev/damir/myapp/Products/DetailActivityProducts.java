package com.dev.damir.myapp.Products;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import com.dev.damir.myapp.R;
public class DetailActivityProducts extends AppCompatActivity {
    TextView nameTxt, anonsTxt, contentTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_actions);
        nameTxt = (TextView) findViewById(R.id.txt);
        anonsTxt = (TextView) findViewById(R.id.nameDetailTxt);
        contentTxt = (TextView) findViewById(R.id.contentDetailTxt);
        Intent i = this.getIntent();
        String name = i.getExtras().getString("NAME_KEY");
        String anons = i.getExtras().getString("ANONS_KEY");
        String content = i.getExtras().getString("CONTENT_KEY");
        nameTxt.setText(name);
        anonsTxt.setText(anons);
        contentTxt.setText(content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
      /*  String name=i.getExtras().getString("NAME KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String username=i.getExtras().getString("USERNAME_KEY");
        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);*/


