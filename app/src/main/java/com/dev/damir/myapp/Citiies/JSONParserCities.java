package com.dev.damir.myapp.Citiies;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParserCities extends AsyncTask<Void, Void, Boolean> {

    Context c;
    String jsonData;
    RecyclerView rv_cities;

    ProgressDialog pd;
    ArrayList<City> cities = new ArrayList<>();

    public JSONParserCities(Context c, String jsonData, RecyclerView rv_cities) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv_cities = rv_cities;
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
            rv_cities.setAdapter(new MyAdapterCities(c, cities));

        } else {
            Toast.makeText(c, "Проверьте Интернет подключение", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean parse() {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            cities.clear();
            City city;

            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String name = jo.getString("name");
                String id = jo.getString("id");
                city = new City();
                city.setName(name);
                city.setId(id);
                cities.add(city);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}



















