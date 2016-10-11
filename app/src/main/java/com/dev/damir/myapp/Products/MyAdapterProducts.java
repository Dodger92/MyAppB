package com.dev.damir.myapp.Products;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.Companies_tab.m_JSON.ItemClickListener;

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
        final String price = product.getPrice();
        final String id=product.getId();
        //BIND
        holder.nameTxt.setText(name);
        holder.anonsTxt.setText(anons);
        holder.contentTxt.setText(price);
        holder.idTxt.setText(id);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name, anons, price,id);
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
        i.putExtra("PRICE_ID", details[3]);
        c.startActivity(i);
    }
}
