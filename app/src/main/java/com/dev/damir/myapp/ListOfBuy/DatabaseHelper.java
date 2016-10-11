package com.dev.damir.myapp.ListOfBuy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myBuyDB";

    // Friend table name
    private static final String TABLE_BUY = "buy";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BUY_TABLE = "CREATE TABLE " + TABLE_BUY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PRICE + " TEXT" + ")";
        db.execSQL(CREATE_BUY_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUY);
        // Create tables again
        onCreate(db);
    }
    // Adding a new record (buy) to table
    public void addNewBuy(List buy) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, buy.getName());
        values.put(KEY_PRICE, buy.getPrice());
        // inserting this record
        db.insert(TABLE_BUY, null, values);
        db.close(); // Closing database connection
    }
    // Getting All Friends in Table of Database
    public java.util.List getAllBuys() {
        java.util.List buyList = new ArrayList<>();
        // select query
        String selectQuery = "SELECT  * FROM " + TABLE_BUY;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all table records and adding to list
        if (cursor.moveToFirst()) {
            do {
                List buy = new List();
                buy.setId(Integer.parseInt(cursor.getString(0)));
                buy.setName(cursor.getString(1));
                buy.setPrice(cursor.getString(2));
                // Adding buy to list
                buyList.add(buy);
            } while (cursor.moveToNext());
        }
        return buyList;
    }
    // Updating a record in database table
   /* public int updateBuy(List buy) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, buy.getName());
        values.put(KEY_PRICE, buy.getPrice());
        // updating row
        return db.update(TABLE_BUY, values, KEY_ID + " = ?", new String[]{String.valueOf(buy.getId())});
    }*/
    // Deleting a record in database table
    public void deleteBuy(List buy) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUY, KEY_ID + " = ?", new String[]{String.valueOf(buy.getId())});
        db.close();
    }

    // getting number of records in table
    public int getContactsCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataCount = db.rawQuery("select " + KEY_ID + " from " + TABLE_BUY, null);
        int count = dataCount.getCount();
        dataCount.close();
        db.close();
        return count;
    }
}