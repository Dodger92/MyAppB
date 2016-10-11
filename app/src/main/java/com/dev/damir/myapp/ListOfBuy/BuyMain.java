package com.dev.damir.myapp.ListOfBuy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.damir.myapp.R;
import com.dev.damir.myapp.api_classes.SharedPreference;

import java.util.ArrayList;

public class BuyMain extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter adapter;
    private DatabaseHelper databaseHelper;
    private java.util.List buyList;
    private TextView title;
    SharedPreference sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listofbuy);
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("name");
        String price = getIntent.getStringExtra("price");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Список покупок");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        listView = (ListView) findViewById(R.id.list_view);
        //title = (TextView)findViewById(R.id.total);
        databaseHelper = new DatabaseHelper(this);
        buyList = new ArrayList<>();
        reloadingDatabase(); //loading table of DB to ListView
    }
    public void reloadingDatabase() {
        buyList = databaseHelper.getAllBuys();
        if (buyList.size() == 0) {
            Toast.makeText(this, "Нет записей в списке покупок!", Toast.LENGTH_SHORT).show();
//            title.setVisibility(View.GONE);
        }
        adapter = new ListViewAdapter(this, R.layout.item_listview, buyList, databaseHelper);
        listView.setAdapter(adapter);
//        title.setVisibility(View.VISIBLE);
//        title.setText("Всего записей: " + databaseHelper.getContactsCount());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_listofbuy, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            addingNewBuyDialog();

            return true;
        }else if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void addingNewBuyDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BuyMain.this);
        alertDialog.setTitle("Добавить товар");
        LinearLayout layout = new LinearLayout(this);
        layout.setPadding(10, 10, 10, 10);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText nameBox = new EditText(this);
        nameBox.setHint("Товар");
        layout.addView(nameBox);
        final EditText priceBox = new EditText(this);
        priceBox.setHint("цена");
        layout.addView(priceBox);
        alertDialog.setView(layout);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List buy = new List(getText(nameBox), getText(priceBox));
                databaseHelper.addNewBuy(buy);
                reloadingDatabase(); //reload the db to view
            }
        });
        alertDialog.setNegativeButton("Отмена", null);
        //show alert
        alertDialog.show();
    }
    //get text available in TextView/EditText
    private String getText(TextView textView) {
        return textView.getText().toString().trim();
    }
}