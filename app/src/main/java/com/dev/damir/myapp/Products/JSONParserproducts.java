package com.dev.damir.myapp.Products;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dev.damir.myapp.Category.m_Model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParserproducts extends AsyncTask<Void, Void, Boolean> {

    Context c;
    String jsonData;
    RecyclerView rv_products;

    ProgressDialog pd;
    ArrayList<Product> cities = new ArrayList<>();

    public JSONParserproducts(Context c, String jsonData, RecyclerView rv_products) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv_products = rv_products;
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
            rv_products.setAdapter(new MyAdapterProducts(c, cities));

        } else {
            Toast.makeText(c, "Невозможно выполнить синтаксический анализ, проверьте подключение", Toast.LENGTH_SHORT).show();
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
                //String content = jo.getString("content");
                String price = jo.getString("price");
                product = new Product();

                product.setName(name);
                product.setAnons(anons);
                //product.setContent(content);
                product.setPrice(price);

                cities.add(product);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}



















