package com.dev.damir.myapp.Citiies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dev.damir.myapp.R;


public class MyViewHolderCities extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView nameTxt,idTxt;
    ItemClickListenerCities itemClickListenerCities;

    public MyViewHolderCities(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        idTxt= (TextView) itemView.findViewById(R.id.idTxt);

        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        this.itemClickListenerCities.onItemClick(this.getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListenerCities itemClickListener) {
        this.itemClickListenerCities = itemClickListener;
    }
}
