package com.dev.damir.myapp.Companies.m_UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.damir.myapp.Companies.m_Model.Company;
import com.dev.damir.myapp.R;

import java.util.ArrayList;

/**
 * Created by Oclemy on 7/8/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 *
 * ---------------------------ROLES-------------------------------
 * | 1.INFLATE MODEL LAYOUT
 * | 2.BIND DATA TO GRIDVIEW
 * ----------------------------------------------------------------
 */
public class CustomAdapter extends BaseAdapter{

    Context c;
    ArrayList<Company> companies;

    public CustomAdapter(Context c, ArrayList<Company> companies) {
        this.c = c;
        this.companies = companies;
    }

    @Override
    public int getCount() {
        return companies.size();
    }

    @Override
    public Object getItem(int i) {
        return companies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=LayoutInflater.from(c).inflate(R.layout.model_company,viewGroup,false);
        }

        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);


        Company city = (Company) this.getItem(i);

        nameTxt.setText(city.getName());


        return view;
    }
}
