package com.example.lab3_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "sinhvienManager";
    // Contacts table name
    private static final String TABLE_SV = "sinhvien";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DIEMTB;

    static {
        KEY_DIEMTB = "diemtb";
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sv_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT,%s FLOAT)", TABLE_SV, KEY_ID, KEY_NAME,KEY_DIEMTB);
        db.execSQL(create_sv_table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SV);
        // Create tables again
        onCreate(db);
    }
    //add sv
    public void addSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, sv.getId());
        values.put(KEY_NAME, sv.getNameSV());
        values.put(KEY_DIEMTB,sv.getDiemTB());
        db.insert(TABLE_SV, null, values);

        db.close();
    }
    // Updating single sv
    public void updateSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, sv.getId());
        values.put(KEY_NAME, sv.getNameSV());
        values.put(KEY_DIEMTB,sv.getDiemTB());
        db.update(TABLE_SV, values, KEY_ID + " = ?", new String[]
                { String.valueOf(sv.getId())});

        db.close();
    }
    // Deleting single contact
    public void deleteSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SV, KEY_ID + " = ?", new String[] { String.valueOf(sv.getId()) });
        db.close();
    }
    // Getting single contact
    public SinhVien getSV(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SV, null, KEY_ID + " = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        SinhVien sv = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getFloat(3));
        return sv;
    }
    // Getting All Contacts
    public List<SinhVien> getAllSV() {
        List<SinhVien>  listSV = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", TABLE_SV);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            SinhVien sv = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getFloat(3));
            listSV.add(sv);
            cursor.moveToNext();
        }
        return listSV;
    }
}

