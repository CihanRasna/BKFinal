package com.example.bkturizm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KULLANICILAR";
    private static final String TABLO_KISILER = "kisiler";
    private static final String TABLO_BILETLER = "bilet";
    private static final String ROW_ID = "id";
    private static final String ROW_AD = "isim";
    private static final String ROW_MAIL = "mail";
    private static final String ROW_SIFRE = "sifre";
    private static final String ROW_TEL = "telefon";
    private static final int DATABASE_VERSION = 6;
    private static final String ROW_BILETID = "biletid";
    private static final String ROW_KALKIS = "kalkis";
    private static final String ROW_VARIS = "varis";
    private static final String ROW_SAAT = "saat";
    private static final String ROW_FIYAT = "fiyat";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLO_KISILER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_MAIL + " TEXT NOT NULL, "
                + ROW_SIFRE + " TEXT NOT NULL, "
                + ROW_TEL + " TEXT NOT NULL)");

        db.execSQL(" CREATE TABLE " + TABLO_BILETLER + "("
                + ROW_BILETID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_SAAT + " TEXT NOT NULL, "
                + ROW_KALKIS + " TEXT NOT NULL, "
                + ROW_VARIS + " TEXT NOT NULL, "
                + ROW_FIYAT + "TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_KISILER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_BILETLER);
        onCreate(db);
    }

    public void addData(String isim, String mail, String sifre, String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ROW_AD, isim);
            contentValues.put(ROW_MAIL, mail);
            contentValues.put(ROW_SIFRE, sifre);
            contentValues.put(ROW_TEL, telefon);
            db.insert(TABLO_KISILER, null, contentValues);
        } catch (Exception e) {
        }
        db.close();
    }

    public void addSeferData(String kalkis, String varis, String saat, String fiyat) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues1 = new ContentValues();
            contentValues1.put(ROW_SAAT, saat);
            contentValues1.put(ROW_KALKIS, kalkis);
            contentValues1.put(ROW_VARIS, varis);
            contentValues1.put(ROW_FIYAT, fiyat);

            db.insert(TABLO_BILETLER, null, contentValues1);
        } catch (Exception e) {
        }
        db.close();
    }



    public List<String> kisiListele() {
        List<String> kisiler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_AD,ROW_MAIL,ROW_SIFRE,ROW_TEL};
            Cursor cursor = db.query(TABLO_KISILER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                kisiler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3)
                        + " - "
                        + cursor.getString(4));
            }
        } catch (Exception e) {
        }
        db.close();
        return kisiler;
    }

    public List<String> rezervasyonListele() {
        List<String> rezerve = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_BILETID,ROW_SAAT,ROW_KALKIS,ROW_VARIS,ROW_FIYAT};
            Cursor cursor = db.query(TABLO_BILETLER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                rezerve.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3)
                        + " - "
                        + cursor.getString(4));
            }
        } catch (Exception e) {
        }
        db.close();
        return rezerve;
    }

}