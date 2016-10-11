package com.dev.damir.myapp.CompanyForAction.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Categories.m_Model.Category;
import com.dev.damir.myapp.CompanyForAction.m_JSON.ItemClickListener;
import com.dev.damir.myapp.Fragments.ActionFragment;
import com.dev.damir.myapp.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Category> categories;

    public MyAdapter(Context c, ArrayList<Category> categories) {
        this.c = c;
        this.categories = categories;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model_company_tab, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Category category = categories.get(position);
        final String name = category.getName();
        final String id = category.getId();
        //BIND
        holder.nameTxt.setText(name);
        holder.id.setText(id);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openAnotherRecycleView(id, name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    private void openAnotherRecycleView(String id, String name) {
        Intent intent = new Intent(c, ActionFragment.class);
        intent.putExtra("id", id);
       // SharedPreference.setCompanyName(c, name);
        c.startActivity(intent);
    }
 /*private void openDetailActivity(String...details){
        Intent i=new Intent(c, DetailActivity.class);
        i.putExtra("NAME_KEY",details[0]);
       // i.putExtra("ANONS_KEY",details[1]);
       // i.putExtra("CONTENT_KEY",details[2]);
        c.startActivity(i);
    }*/
}
