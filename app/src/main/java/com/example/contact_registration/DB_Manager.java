package com.example.contact_registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Manager extends SQLiteOpenHelper {
    public DB_Manager(Context context) {
        super(context, "contacts_db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table contact_tbl(ID INTEGER PRIMARY KEY AUTOINCREMENT,name text, email text, phone text,profession text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int old, int newversion) {
        DB.execSQL("DROP TABLE IF EXISTS contact_tbl");
    }

    public boolean insertdata(String name, String email, String phone, String profession) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put(profession, profession);
        long result = db.insert("contact_tbl", null, values);
    if(result==0){
       return  false;
    }
    else{
         return  true;
    }
    }


}
