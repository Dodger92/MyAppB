package com.dev.damir.myapp.Basket;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dev.damir.myapp.Companies_tab.m_JSON.Connector;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class JSONDownloaderBasket extends AsyncTask<Void, Void, String> {

    Context c;
    String jsonURL5;
    RecyclerView rv_basket;

    ProgressDialog pd;

    public JSONDownloaderBasket(Context c, String jsonURL5, RecyclerView rv_products) {
        this.c = c;
        this.jsonURL5 = jsonURL5;
        this.rv_basket = rv_products;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Загрузка данных");
        pd.setMessage("Загрузка...Пожалуйста подождите");
        pd.show();

    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();
        if (jsonData.startsWith("Ошибка")) {
            Toast.makeText(c, jsonData, Toast.LENGTH_SHORT).show();
        } else {
            //PARSER
            new JSONParserBasket(c, jsonData, rv_basket).execute();
        }

    }

    //DOWNLOAD
    private String download() {
        Object connection = Connector.connect(jsonURL5);
        if (connection.toString().startsWith("Ошибка")) {
            return connection.toString();
        }

        try {
            HttpURLConnection con = (HttpURLConnection) connection;
            if (con.getResponseCode() == con.HTTP_OK) {
                //GET INPUT FROM STREAM
                InputStream is = new BufferedInputStream(con.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line;
                StringBuffer jsonData = new StringBuffer();

                //READ
                while ((line = br.readLine()) != null) {
                    jsonData.append(line + "\n");
                }

                //CLOSE RESOURCES
                br.close();
                is.close();

                //RETURN JSON
                return jsonData.toString();

            } else {
                return "Error " + con.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();

        }
    }
}















