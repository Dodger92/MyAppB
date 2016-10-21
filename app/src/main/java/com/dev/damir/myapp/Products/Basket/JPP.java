package com.dev.damir.myapp.Products.Basket;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dev.damir.myapp.Products.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JPP extends AsyncTask<Void, Void, Boolean> {
    Context c;
    String jsonData;


    ArrayList<Product> cities = new ArrayList<>();

    public JPP(Context c, String jsonData) {
        this.c = c;
        this.jsonData = jsonData;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        if (isParsed) {
            //BIND
            Toast.makeText(c, "Ошибка в добавлении", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(c, "Добавлен в список покупок", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parse() {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            cities.clear();
            Product product;

            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String name = jo.getString("name");
                String anons = jo.getString("anons");
                String price = jo.getString("price");
                String id=jo.getString("id");
                product = new Product();

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



















