package com.dev.damir.myapp.Basket;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.damir.myapp.Companies_tab.m_JSON.ItemClickListener;
import com.dev.damir.myapp.R;

public class MyViewHolderBasket extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nameTxt, anonsTxt,contentTxt,idTxt;
    ItemClickListener itemClickListener;
    public MyViewHolderBasket(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        anonsTxt = (TextView) itemView.findViewById(R.id.anonsTxt);
        contentTxt= (TextView) itemView.findViewById(R.id.contentTxt);
        idTxt= (TextView) itemView.findViewById(R.id.idTxt);
        img = (ImageView) itemView.findViewById(R.id.modelView);
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
   this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
