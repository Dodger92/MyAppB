package com.dev.damir.myapp.Basket;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Basket.DeleteBtn.JDBDelete;
import com.dev.damir.myapp.R;

import java.util.ArrayList;


public class MyAdapterBasket extends RecyclerView.Adapter<MyViewHolderBasket> {
    Context c;
    ArrayList<Basket> products;
    String jsonURL10;
    MenuView.ItemView itemView;

    public MyAdapterBasket(Context c, ArrayList<Basket> products) {
        this.c = c;
        this.products = products;
    }

    @Override
    public MyViewHolderBasket onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model_basket, parent, false);

        return new MyViewHolderBasket(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolderBasket holder, final int position) {
        final Basket product = products.get(position);
        final String name = product.getName();
        final String anons = product.getAnons();
        final String price = product.getPrice();
        final String id = product.getId();
        //BIND
        holder.nameTxt.setText(name);
        holder.anonsTxt.setText(anons);
        holder.contentTxt.setText(price);
        holder.idTxt.setText(id);
        //Открытие активити при нажатии на item
      /*  holder.setItemClickListener(new ItemClickListenerBasket() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name, anons, price,id);
            }
        });*/
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonURL10 = "http://deliveryking.kz/mobile_api/public_html/?page=delete_liked&id=" + id;
                new JDBDelete(c, jsonURL10).execute();
                delete(position);//удаляем Item
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    private void openDetailActivity(String... details) {
        Intent i = new Intent(c, BasketDetailActivity.class);
        i.putExtra("NAME_KEY", details[0]);
        i.putExtra("ANONS_KEY", details[1]);
        i.putExtra("PRICE_KEY", details[2]);
        i.putExtra("PRICE_ID", details[3]);
        c.startActivity(i);
    }

    public void delete(int position) { //removes the row
        products.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, products.size());


    }

    public void clearData() {
        int size = this.products.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.products.remove(0);
            }
            this.notifyItemRangeRemoved(0, size);
        }
    }

}
