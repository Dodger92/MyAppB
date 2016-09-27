package com.dev.damir.myapp.Products;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.damir.myapp.R;
import com.dev.damir.myapp.Category.m_JSON.ItemClickListener;


public class MyViewHolderProducts extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;

    TextView nameTxt, idTxt,contentTxt;
    ItemClickListener itemClickListener;

    public MyViewHolderProducts(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        idTxt = (TextView) itemView.findViewById(R.id.anonsTxt);
        contentTxt= (TextView) itemView.findViewById(R.id.contentTxt);
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
