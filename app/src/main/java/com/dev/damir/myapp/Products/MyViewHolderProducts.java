package com.dev.damir.myapp.Products;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.dev.damir.myapp.R;
import com.dev.damir.myapp.Companies_tab.m_JSON.ItemClickListener;
public class MyViewHolderProducts extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nameTxt, anonsTxt,contentTxt,idTxt;
    ItemClickListener itemClickListener;
    ImageButton addButton;
    public MyViewHolderProducts(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        anonsTxt = (TextView) itemView.findViewById(R.id.anonsTxt);
        contentTxt= (TextView) itemView.findViewById(R.id.contentTxt);
        idTxt= (TextView) itemView.findViewById(R.id.idTxt);
        img = (ImageView) itemView.findViewById(R.id.modelView);
        addButton=(ImageButton)itemView.findViewById(R.id.addButton);
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
