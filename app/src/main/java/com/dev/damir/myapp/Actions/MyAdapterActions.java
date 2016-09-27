package com.dev.damir.myapp.Actions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.damir.myapp.Category.m_Model.Action;
import com.dev.damir.myapp.R;

import java.util.ArrayList;

public class MyAdapterActions extends RecyclerView.Adapter<MyViewHolderActions> {

    Context c;
    ArrayList<Action> actions;

    public MyAdapterActions(Context c, ArrayList<Action> actions) {
        this.c = c;
        this.actions = actions;
    }

    @Override
    public MyViewHolderActions onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model_actions, parent, false);
        return new MyViewHolderActions(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolderActions holder, int position) {

        Action action = actions.get(position);
        final String name = action.getName();
        final String content = action.getContent();

        //BIND
        holder.nameTxt.setText(name);
        holder.contentTxt.setText(content);
        holder.setItemClickListenerActions(new ItemClickListenerActions() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name, content);
            }
        });
    }
        private void openDetailActivity(String...details){
        Intent i=new Intent(c, DetailActivityActions.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("CONTENT_KEY",details[1]);
        c.startActivity(i);
    }
    @Override
    public int getItemCount() {
        return actions.size();
    }

    }

