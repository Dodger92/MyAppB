package com.dev.damir.myapp.Actions;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dev.damir.myapp.Category.m_Model.Action;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParserActions extends AsyncTask<Void, Void, Boolean> {

    Context c;
    String jsonData;
    RecyclerView rv_actions;

    ProgressDialog pd;
    ArrayList<Action> actions = new ArrayList<>();

    public JSONParserActions(Context c, String jsonData, RecyclerView rv_actions) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv_actions = rv_actions;
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
            rv_actions.setAdapter(new MyAdapterActions(c, actions));

        } else {
            Toast.makeText(c, "Невозможно выполнить синтаксический анализ, проверьте подключение", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parse() {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            actions.clear();
            Action action;

            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String name = jo.getString("name");
                String content = jo.getString("content");
                action = new Action();
                action.setName(name);
                action.setContent(content);
                actions.add(action);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}



















