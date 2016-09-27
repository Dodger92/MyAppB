package com.dev.damir.myapp.Products;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Category.m_Model.Product;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.Category.m_JSON.DetailActivity;
import com.dev.damir.myapp.Category.m_JSON.ItemClickListener;

import java.util.ArrayList;

public class MyAdapterProducts extends RecyclerView.Adapter<MyViewHolderProducts> {

    Context c;
    ArrayList<Product> products;

    public MyAdapterProducts(Context c, ArrayList<Product> products) {
        this.c = c;
        this.products = products;
    }

    @Override
    public MyViewHolderProducts onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model_products, parent, false);
        return new MyViewHolderProducts(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolderProducts holder, int position) {
        Product product = products.get(position);
        final String name = product.getName();
        final String anons = product.getAnons();
        //final String content=product.getContent();
        final String price = product.getPrice();
        //BIND
        holder.nameTxt.setText(name);
        holder.idTxt.setText(anons);
        //holder.contentTxt.setText(content);
        holder.contentTxt.setText(price);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name, anons, price);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    private void openDetailActivity(String... details) {
        Intent i = new Intent(c, DetailActivity.class);
        i.putExtra("NAME_KEY", details[0]);
        i.putExtra("ANONS_KEY", details[1]);
        i.putExtra("PRICE_KEY", details[2]);
        c.startActivity(i);
    }
}
