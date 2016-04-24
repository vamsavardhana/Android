package com.example.anna.assignment3parta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anna.assignment3parta.Util.Util;
import com.example.anna.assignment3parta.model.Model;
import com.example.anna.assignment3parta.stats.Student;
import com.example.anna.assignment3parta.stats.statistics;


public class MainActivity extends Activity {
    Button submitrecord;

    //    Student[] students = new Student[100];
//    statistics stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitrecord = (Button) findViewById(R.id.calculate);
        submitrecord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Student[] students = new Student[100];
                statistics stat = new statistics();
                Context context1=MyApp.getContext();
                Util util1=new Util(context1,"db1.db", null,1);;
                Model modelobject=new Model();
                students = Util.readFile("vijay.txt", students);
                int t1=util1.low1;
                int t2=util1.low2;
                int t3=util1.low3;
                int t4=util1.low4;
                int t5=util1.low5;
                String LOW=t1+" "+t2+" "+t3+" "+t4+" "+t5+" ";
                Log.i("LOW",LOW);
                modelobject.setLOW(LOW);
                int t10=util1.high1;
                int t20=util1.high2;
                int t30=util1.high3;
                int t40=util1.high4;
                int t50=util1.high5;
                String HIGH=t10+" "+t20+" "+t30+" "+t40+" "+t50+" ";
                Log.i("HIGH",HIGH);
                modelobject.setHIGH(HIGH);
                int t11=util1.avg1;
                int t21=util1.avg2;
                int t31=util1.avg3;
                int t41=util1.avg4;
                int t51=util1.avg5;
                int nocolumn=util1.nocolumn;
                String AVG=t11+" "+t21+" "+t31+" "+t41+" "+t51+" ";
                Log.i("AVG", AVG);
                modelobject.setAVG(AVG);
                modelobject.setnocolumn(nocolumn);
                stat.findLow(students);
                stat.findHigh(students);
                stat.findAverage(students);
                Intent newIntent = new Intent(MainActivity.this, SecondActivity.class).putExtra("modelobject", modelobject);
                startActivity(newIntent);


            }


        });
    }
}