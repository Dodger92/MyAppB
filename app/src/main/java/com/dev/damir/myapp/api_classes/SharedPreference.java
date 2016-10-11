package com.dev.damir.myapp.api_classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreference {

    static final String CITY_ID = "username";
    static final String COMPANY_NAME = "company";
    static final String CITY_NAME_VALUE = "city_value";
    static final String CITY_INFO = "cityInfo";
    static final String BUY_NAME = "buyName";
    static final String BUY_PRICE = "buyPrice";
    static final String BASKET="basket";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static String getBASKET() {
        return BASKET;
    }
    public static void setBASKET(Context ctx, String basket) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(BASKET, basket);
        editor.commit();
    }

    public static String getBuyName() {
        return BUY_NAME;
    }
    public static void setBuyName(Context ctx, String buyName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(BUY_NAME, buyName);
        editor.commit();
    }

    public static String getBuyPrice() {
        return BUY_PRICE;
    }
    public static void setBuyPrice(Context ctx, String buyPrice) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(BUY_PRICE, buyPrice);
        editor.commit();
    }

    public static String getCityNameValue(Context ctx) {
        return getSharedPreferences(ctx).getString(CITY_NAME_VALUE, "");
    }

    public static void setCityNameValue(Context ctx, String city_value) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CITY_NAME_VALUE, city_value);
        editor.commit();
    }

    public static void setCompanyName(Context ctx, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(COMPANY_NAME, userName);
        editor.commit();
    }

    public static String getCompanyName(Context ctx) {
        return getSharedPreferences(ctx).getString(COMPANY_NAME, "");

    }

    public static void setCityId(Context ctx, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CITY_ID, userName);
        editor.commit();
    }

    public static String getCityId(Context ctx) {
        return getSharedPreferences(ctx).getString(CITY_ID, "");

    }

    public static void clearUserName(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.commit();
    }

    public static void clearV1(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.commit();
    }


}
