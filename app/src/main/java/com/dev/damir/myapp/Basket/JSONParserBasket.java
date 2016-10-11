package com.dev.damir.myapp.Basket;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParserBasket extends AsyncTask<Void, Void, Boolean> {
    Context c;
    String jsonData;
    RecyclerView rv_basket;

    ProgressDialog pd;
    ArrayList<Basket> cities = new ArrayList<>();

    public JSONParserBasket(Context c, String jsonData, RecyclerView rv_products) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv_basket = rv_products;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Обработка");
        pd.setMessage("Обработка...Пожалуйста подождите");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if (isParsed) {
            //BIND
            rv_basket.setAdapter(new MyAdapterBasket(c, cities));

        } else {
            Toast.makeText(c, "В выбранной категории,нет данных для отображения", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean parse() {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            cities.clear();
            Basket product;

            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String name = jo.getString("name");
                String anons = jo.getString("anons");
                String price = jo.getString("price");
                String id=jo.getString("id");
                product = new Basket();

                product.setName(name);
                product.setAnons(anons);
                product.setPrice(price);
                product.setId(id);

                cities.add(product);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}



















