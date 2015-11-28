package com.user.hakan.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hakan on 27.11.2015.
 */
public class Database extends SQLiteOpenHelper
{


    private static  final String VERİTABANI_ADI="kullanicilar";
    private static  final int SURUM=1;
    private static  final String VERI_TABLO="kullanicibilgileri";
    private static  final String VERI_ID="id";
    private static  final String VERI_AD="ad";
    private static  final String VERI_SOYAD="soyad";
    private static  final String VERI_KADI="kadi";
    private static  final String VERI_SIFRE="sifre";
    private static  final String VERI_SIFRETEK="sifretek";




    public Database(Context context) {

        super(context,VERİTABANI_ADI,null,SURUM);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_kullanicibilgileri="CREATE TABLE" + VERI_TABLO +"("+VERI_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
        +VERI_AD+"TEXT,"
                +VERI_SOYAD+"TEXT,"
                +VERI_KADI+"TEXT,"
                +VERI_SIFRE+"TEXT,"
                +VERI_SIFRETEK+"TEXT"+")";
        sqLiteDatabase.execSQL(create_kullanicibilgileri);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST kullanicibilgileri");
        onCreate(sqLiteDatabase);
    }


    public  void KullaniciEkle(String ad,String soyad,String kullaniciadi,String sifre,String sifretekrar)
{
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    ContentValues cv= new ContentValues();
    cv.put(VERI_AD,ad);
    cv.put(VERI_SOYAD,soyad);
    cv.put(VERI_KADI,kullaniciadi);
    cv.put(VERI_SIFRE,sifre);
    cv.put(VERI_SIFRETEK,sifretekrar);
    sqLiteDatabase.insert(VERI_TABLO,null,cv);
    sqLiteDatabase.close();


}
}
