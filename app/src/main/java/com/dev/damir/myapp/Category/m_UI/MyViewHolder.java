package com.dev.damir.myapp.Category.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.Category.m_JSON.ItemClickListener;


public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nameTxt;
    TextView id;
    ItemClickListener itemClickListener;
    public MyViewHolder(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        id= (TextView) itemView.findViewById(R.id.id);
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
