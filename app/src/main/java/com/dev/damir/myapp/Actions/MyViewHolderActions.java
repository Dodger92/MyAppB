package com.dev.damir.myapp.Actions;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.damir.myapp.R;


public class MyViewHolderActions extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;

    TextView nameTxt,anonsTxt,contentTxt;
    //ItemClickListener itemClickListener;
    ItemClickListenerActions itemClickListenerActions;

    public MyViewHolderActions(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        anonsTxt= (TextView) itemView.findViewById(R.id.anonsTxt);
        contentTxt= (TextView) itemView.findViewById(R.id.contentTxt);
        img = (ImageView) itemView.findViewById(R.id.modelView);
        itemView.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
  this.itemClickListenerActions.onItemClick(this.getLayoutPosition());
    }
    public void setItemClickListenerActions(ItemClickListenerActions itemClickListenerActions) {
        this.itemClickListenerActions = itemClickListenerActions;
    }
}
