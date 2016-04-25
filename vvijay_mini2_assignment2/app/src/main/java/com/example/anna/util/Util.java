package com.example.anna.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.anna.model.Model;

/**
 * Created by anna on 3/19/16.
 */
public class Util extends SQLiteOpenHelper {
    public int getMonthlyPayment, totalPaymentMortgageTerm;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db1.db";
    private static final String TABLE_NAME = "table1";
    public static final String TABLE_C_0 = "s_no";
    public static final String TABLE_C_1 = "purchaseprice";
    public static final String TABLE_C_2 = "downpayment";
    public static final String TABLE_C_3 = "mortgageterm";
    public static final String TABLE_C_4 = "interestrate";
    public static final String TABLE_C_5 = "propertytax";
    public static final String TABLE_C_6 = "propertyinsurance";

    public Util(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "CREATE TABLE " + TABLE_NAME + " (" + TABLE_C_0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TABLE_C_1 + " INT, " + TABLE_C_2 + " INT, " + TABLE_C_3 + " INT, " + TABLE_C_4
                + " INT, " + TABLE_C_5 + " INT, " + TABLE_C_6 + " INT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    public void addModel(Model model1) {
        ContentValues values = new ContentValues();
        values.put(TABLE_C_1, model1.purchasePrice);
        values.put(TABLE_C_2, model1.downPayment);
        values.put(TABLE_C_3, model1.mortgageTerm);
        values.put(TABLE_C_4, model1.interestRate);
        values.put(TABLE_C_5, model1.propertyTax);
        values.put(TABLE_C_6, model1.propertyInsurance);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String dBtoString()
    {
      String dbstring="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToLast();
        int t1=c.getColumnIndex("purchaseprice");
        int t2=c.getColumnIndex("downpayment");
        int t3=c.getColumnIndex("mortgageterm");
        int t4=c.getColumnIndex("interestrate");
        int t5=c.getColumnIndex("propertytax");
        int t6=c.getColumnIndex("propertyinsurance");
        Log.i("pi",(String)(t6+" "));
        dbstring=c.getInt(t1)+" "+c.getInt(t2)+" "+c.getInt(t3)+" "+c.getInt(t4)+" "+c.getInt(t5)+" "+c.getInt(t6)+" ";
Log.i("dbstring", dbstring);
    return dbstring;
    }
}
