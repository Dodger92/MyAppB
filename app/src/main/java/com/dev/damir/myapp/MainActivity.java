package com.dev.damir.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dev.damir.myapp.Basket.BasketFragment;
import com.dev.damir.myapp.Fragments.CitiesFragment;
import com.dev.damir.myapp.Fragments.HomeFragment;
import com.dev.damir.myapp.Fragments.UsersFragment;
import com.dev.damir.myapp.api_classes.SharedPreference;

public class MainActivity extends AppCompatActivity {
    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;
    TextView CityNameTxt,changeCityTxt;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         String android_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
      //  Toast.makeText(this,  android_id, Toast.LENGTH_SHORT).show();
        SharedPreference.setBASKET(getApplication(),android_id);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        myNavigationView = (NavigationView) findViewById(R.id.nav_drawer);
        View viewNav = myNavigationView.getHeaderView(0);
        CityNameTxt = (TextView) viewNav.findViewById(R.id.CityNameTxt);
        changeCityTxt=(TextView)viewNav.findViewById(R.id.changeCityTxt);
        CityNameTxt.setText(SharedPreference.getCityNameValue(getApplication()));
        changeCityTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplication(),CitiesFragment.class);
               startActivity(intent1);
            }
        });
        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        myFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem selectedMenuItem) {
                myDrawerLayout.closeDrawers();
                if (selectedMenuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();
                    toolbar.setTitle("Компании");

                }
                /*if (selectedMenuItem.getItemId() == R.id.nav_item_statistics) {
                    FragmentTransaction xfragmentTransaction = myFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new StatictisFragment()).commit();
                }*/
                /*if (selectedMenuItem.getItemId() == R.id.nav_item_company) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CompanyFragment()).commit();
                    toolbar.setTitle("Выберите компанию");

                }*/
                if (selectedMenuItem.getItemId() == R.id.nav_item_action) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SecondTab()).commit();
                    toolbar.setTitle("Акции");
                }
                if (selectedMenuItem.getItemId() == R.id.nav_item_users) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new UsersFragment()).commit();
                    toolbar.setTitle("О проекте");
                }
               /* if (selectedMenuItem.getItemId() == R.id.nav_item_category) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CitiesFragment()).commit();
                    toolbar.setTitle("Выберите город")
                };*/
                if (selectedMenuItem.getItemId() == R.id.nav_item_list_buy){
                    Intent intent5=new Intent(MainActivity.this, BasketFragment.class);
                    startActivity(intent5);
                    //FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    //fragmentTransaction.replace(R.id.containerView, new BasketFragment()).commit();
                   // toolbar.setTitle("Список покупок");
                  //  FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
               // fragmentTransaction.replace(R.id.containerView, new BasketFragment()).commit();
                          }
                return false;
            }

        });
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);
        toolbar.setTitle("Компании");
        myDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    }

