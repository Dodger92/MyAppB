package com.dev.damir.myapp.Products.Basket;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.dev.damir.myapp.Companies_tab.m_JSON.Connector;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
public class JDB extends AsyncTask<Void, Void, String> {
    Context c;
    String jsonURL2;
    public JDB(Context c, String jsonURL2) {
        this.c = c;
        this.jsonURL2 = jsonURL2;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }
    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        if (jsonData.startsWith("Ошибка")) {
            Toast.makeText(c, jsonData, Toast.LENGTH_SHORT).show();
        } else {
            //PARSER
            new JPP(c, jsonData).execute();
        }
    }
    //DOWNLOAD
    private String download() {
        Object connection = Connector.connect(jsonURL2);
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
