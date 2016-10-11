package com.dev.damir.myapp.ListOfBuy;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.api_classes.SharedPreference;

public class ListViewAdapter extends ArrayAdapter<List> {

    private BuyMain activity;
    private DatabaseHelper databaseHelper;
    private java.util.List buyList;
    SharedPreference sharedPreference;

    public ListViewAdapter(BuyMain context, int resource, java.util.List objects, DatabaseHelper helper) {
        super(context, resource, objects);
        this.activity = context;
        this.databaseHelper = helper;
        this.buyList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(getItem(position).getName());
        //Delete an item
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteBuy(getItem(position)); //delete in db
                Toast.makeText(activity, "Удалено!", Toast.LENGTH_SHORT).show();
                //reload the database to view
                activity.reloadingDatabase();
            }
        });
        //Edit/Update an item
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
                alertDialog.setTitle("Обновить товар");
                LinearLayout layout = new LinearLayout(activity);
                layout.setPadding(10, 10, 10, 10);
                layout.setOrientation(LinearLayout.VERTICAL);
                final EditText nameBox = new EditText(activity);
                nameBox.setHint("Товар");
                layout.addView(nameBox);
                final EditText jobBox = new EditText(activity);
                jobBox.setHint("Цена");
                layout.addView(jobBox);
                nameBox.setText(getItem(position).getName());
                jobBox.setText(getItem(position).getPrice());
                alertDialog.setView(layout);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        List buy = new List(nameBox.getText().toString(), jobBox.getText().toString());
                        buy.setId(getItem(position).getId());
                       // databaseHelper.updateBuy(buy); //update to db
                        Toast.makeText(activity, "Обновлено!", Toast.LENGTH_SHORT).show();
                        //reload the database to view
                        activity.reloadingDatabase();
                    }
                });
                alertDialog.setNegativeButton("Отмена", null);
                //show alert
                alertDialog.show();
            }
        });
        //show details when each row item clicked
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
                alertDialog.setTitle("Товар ");
                LinearLayout layout = new LinearLayout(activity);
                layout.setPadding(10, 10, 10, 10);
                layout.setOrientation(LinearLayout.VERTICAL);
                TextView nameBox = new TextView(activity);
                layout.addView(nameBox);
                TextView jobBox = new TextView(activity);
                layout.addView(jobBox);
                nameBox.setText("Название товара: " + getItem(position).getName());
                jobBox.setText("Цена: " + getItem(position).getPrice());
                alertDialog.setView(layout);
                alertDialog.setNegativeButton("OK", null);
                //show alert
                alertDialog.show();
            }
        });
        return convertView;
    }
    private static class ViewHolder {
        private TextView name;
        private View btnDelete;
        private View btnEdit;
        public void setName(TextView name) {
            this.name = name;
        }
        public ViewHolder (View v) {
            name = (TextView)v.findViewById(R.id.item_name);
            btnDelete = v.findViewById(R.id.delete);
            btnEdit = v.findViewById(R.id.edit);
        }
    }
}