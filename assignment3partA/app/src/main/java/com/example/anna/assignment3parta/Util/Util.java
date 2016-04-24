package com.example.anna.assignment3parta.Util;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.StringTokenizer;

import com.example.anna.assignment3parta.Except.Greater40RecordsException;
import com.example.anna.assignment3parta.MainActivity;
import com.example.anna.assignment3parta.MyApp;
import com.example.anna.assignment3parta.stats.Student;

public class Util extends SQLiteOpenHelper{
    SQLiteDatabase db=getWritableDatabase();
    Util util1;
    public static int low1=0,low2=0,low3,low4,low5;
    public static int high1,high2,high3,high4,high5;
    public static int avg1,avg2,avg3,avg4,avg5,nocolumn;
    static int[] marks = new int[5];
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db1.db";
    private static final String TABLE_NAME = "TABLE_Name";
    public static final String TABLE_C_0 = "s_no";
    public static final String TABLE_C_1 = "test1";
    public static final String TABLE_C_2 = "test2";
    public static final String TABLE_C_3 = "test3";
    public static final String TABLE_C_4 = "test4";
    public static final String TABLE_C_5 = "test5";
    Context context1;
    SQLiteDatabase.CursorFactory factory1;
    static int count = 0;
    public Util(Context context,String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        context1=context;
        factory1=factory;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query;
        query = "CREATE TABLE " + TABLE_NAME + " (" + TABLE_C_0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TABLE_C_1 + " INT, " + TABLE_C_2 + " INT, " + TABLE_C_3 + " INT, " + TABLE_C_4
                + " INT, "  + TABLE_C_5 + " INT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }


    public static Student[] readFile(String filename, Student[] stu){
        Context context1= MyApp.getContext();
        Util util1=new Util(context1,DATABASE_NAME,null ,DATABASE_VERSION);
        try {
            Log.i("Line1","FIlesdccard");
            File sdcard = Environment.getExternalStorageDirectory();
            Log.i("Line2","newfile");
//Get the text file
            File file = new File(sdcard,filename);
            Log.i("Line3","buffreader");

            BufferedReader buff = new BufferedReader(new FileReader(file));
            //Read the first line that contains stud, q1,q2,q3,q4 and q5
            Log.i("Line4","readline");
            buff.readLine();
            boolean eof = false;
            int j = 0;
            //Populate each students SID and marks
            while (!eof) {

                String line = buff.readLine();
                Log.i("lines", line + "");
                if (line == null) {
                    Log.i("is line null","is line null");
                    eof = true;
                } else {
                    Log.i("is line not null","is line not null");

                    //Tokenize each string the default delimiter is " " or space
                    StringTokenizer st = new StringTokenizer(line," ");
                    int numberOfToken = st.countTokens();
                    if(numberOfToken==0)
                    {
                      eof=true;
                        break;
                    }
                    Log.i("nooftokens",numberOfToken+"");
                    //Initialize new student
                    stu[count] = new Student();
                    //Log.i("Sts next token",st.nextToken());
                    //Set the student ID for each student
                    stu[count].setSID(Integer.parseInt(st.nextToken()));

                    //Set the scores of one student to an array called marks

                    for (int i = 0; i < numberOfToken-1; i++) {
                        String temp = st.nextToken();
                        marks[i] = Integer.parseInt(temp);
                    }
                    util1.dbinsert(marks);
                    stu[count].setScores(marks);

                    count++;
                    testException(count);

                }
            }

            Log.i("before findlow", "before findlow");


     //               util1.findlow();
            Log.i("after findlow","after findlow");
            buff.close();

        } catch (IOException e) {
            System.err.println("Error ­­ this is IO exception" + e.toString());
        }
        catch(Greater40RecordsException e)
        {
        //    e.printStackTrace();
        }
        SQLiteDatabase db= util1.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT min(test1) from TABLE_Name ", null);
        c.moveToFirst();
        Log.i("JUSTFORCHECK1", c.getInt(0) + "!!");
        util1.low1=c.getInt(0);
        util1.setLow1(util1.low1);
        c = db.rawQuery("SELECT min(test2) from TABLE_Name ", null);
        c.moveToFirst();
        util1.low2=c.getInt(0);
        util1.setLow2(util1.low2);
        Log.i("JUSTFORCHECK2", c.getInt(0) + "!!");
        c = db.rawQuery("SELECT min(test3) from TABLE_Name ", null);
        c.moveToFirst();
        util1.low3=c.getInt(0);
        util1.setLow3(util1.low3);
        Log.i("JUSTFORCHECK3",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT min(test4) from TABLE_Name ", null);
        c.moveToFirst();
        util1.low4=c.getInt(0);
        util1.setLow4(util1.low4);
        Log.i("JUSTFORCHECK4",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT min(test5) from TABLE_Name ", null);
        c.moveToFirst();
        util1.low5=c.getInt(0);
        util1.setLow5(util1.low5);
        Log.i("JUSTFORCHECK5",c.getInt(0)+"!!");
        //HIGH scores
        c = db.rawQuery("SELECT max(test2) from TABLE_Name ", null);
        c.moveToFirst();
        util1.high2=c.getInt(0);
        util1.setHigh2(util1.high2);
        Log.i("JUSTFORCHECK1",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT max(test3) from TABLE_Name ", null);
        c.moveToFirst();
        util1.high3=c.getInt(0);
        util1.setHigh3(util1.high3);
        Log.i("JUSTFORCHECK2",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT max(test4) from TABLE_Name ", null);
        c.moveToFirst();
        util1.high4=c.getInt(0);
        util1.setHigh4(util1.high4);
        Log.i("JUSTFORCHECK3",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT max(test5) from TABLE_Name ", null);
        c.moveToFirst();
        util1.high5=c.getInt(0);
        util1.setHigh5(util1.high5);
        Log.i("JUSTFORCHECK4",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT max(test1) from TABLE_Name ", null);
        c.moveToFirst();
        util1.high1=c.getInt(0);
        util1.setHigh1(util1.high1);
        Log.i("JUSTFORCHECK5",c.getInt(0)+"!!");
//      AVERAGE SCORES
        c = db.rawQuery("SELECT avg(test2) from TABLE_Name ", null);
        c.moveToFirst();
        util1.avg2=c.getInt(0);
        util1.setAvg2(util1.avg2);
        Log.i("JUSTFORCHECK1",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT avg(test3) from TABLE_Name ", null);
        c.moveToFirst();
        util1.avg3=c.getInt(0);
        util1.setAvg3(util1.avg3);
        Log.i("JUSTFORCHECK2",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT avg(test4) from TABLE_Name ", null);
        c.moveToFirst();
        util1.avg4=c.getInt(0);
        util1.setAvg4(util1.avg4);
        Log.i("JUSTFORCHECK3",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT avg(test5) from TABLE_Name ", null);
        c.moveToFirst();
        util1.avg5=c.getInt(0);
        util1.setAvg5(util1.avg5);
        Log.i("JUSTFORCHECK4",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT avg(test1) from TABLE_Name ", null);
        c.moveToFirst();
        util1.avg1=c.getInt(0);
        util1.setAvg1(util1.avg1);
        Log.i("JUSTFORCHECK5",c.getInt(0)+"!!");
        c = db.rawQuery("SELECT * from TABLE_Name ", null);
        util1.nocolumn=c.getCount();
        util1.setnocolumn(util1.nocolumn);
//        Log.i("JUSTFORCHECK5",c.getInt(0)+"!!");

        return stu;
    }
    public static void testException(int nrecords) throws Greater40RecordsException
    {
        if(nrecords>40)
            throw new Greater40RecordsException();
    }
    public String[] readscores()
    {
        SQLiteDatabase db= getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * from TABLE_Name ", null);
        String[] str=new String[nocolumn];
        c.moveToFirst();
        for(int i=0;i<nocolumn;i++)
        {
        str[i]= c.getInt(0)+" "+c.getInt(1)+" "+c.getInt(2)+" "+c.getInt(3)+" "+c.getInt(4)+" "+c.getInt(5);
            c.moveToNext();
            if(c.isLast())
            {
                break;
            }
    }
    return str;}
    public void dbinsert(int[] marks)
    {
        ContentValues values = new ContentValues();
        values.put(TABLE_C_1, marks[0]);
        values.put(TABLE_C_2, marks[1]);
        values.put(TABLE_C_3, marks[2]);
        values.put(TABLE_C_4, marks[3]);
        values.put(TABLE_C_5, marks[4]);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
        }

    public void setLow1(int LOW) {
        this.low1 = LOW;
    }
    public void setLow2(int LOW) {
        this.low2 = LOW;
    }
    public void setLow3(int LOW) {
        this.low3 = LOW;
    }
    public void setLow4(int LOW) {
        this.low4 = LOW;
    }
    public void setLow5(int LOW) {
        this.low5 = LOW;
    }
//HIGHS setting
public void setHigh1(int HIGH) {
    this.high1 = HIGH;
}
    public void setHigh2(int HIGH) {
        this.high2 = HIGH;
    }

    public void setHigh3(int HIGH) {
        this.high3 = HIGH;
    }

    public void setHigh4(int HIGH) {
        this.high4 = HIGH;
    }

    public void setHigh5(int HIGH) {
        this.high5 = HIGH;
    }
//AVERAGES
public void setAvg1(int AVG) {
    this.avg1 = AVG;
}
    public void setAvg2(int AVG) {
        this.avg2 = AVG;
    }

    public void setAvg3(int AVG) {
        this.avg3 = AVG;
    }
    public void setAvg4(int AVG) {
        this.avg4 = AVG;
    }
    public void setAvg5(int AVG) {
        this.avg5 = AVG;
    }
    public void setnocolumn(int nocolumn) {
        this.nocolumn = nocolumn;
    }

}