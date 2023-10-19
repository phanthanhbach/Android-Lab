package com.example.lab3_2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private SQLiteDatabase sqLiteDatabase;

    public Contact(String ravi, String s) {
        this.name = ravi;
        this.phoneNumber = s;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    public Cursor getAllUsers() {
//        //return sqLiteDatabase.query(new Contact[]{id, name, phoneNumber}, null, null, null, null, null);
//    }
    //….
}
