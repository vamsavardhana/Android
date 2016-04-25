package com.example.anna.assignment3parta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.anna.assignment3parta.Util.Util;
import com.example.anna.assignment3parta.model.Model;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView et2=(TextView)findViewById(R.id.tv2);
        TextView et4=(TextView)findViewById(R.id.tv4);
        TextView et6=(TextView)findViewById(R.id.tv6);
        Intent i=getIntent();
        Model model1=(Model)i.getSerializableExtra("modelobject");
        et2.setText(model1.LOW);
        et4.setText(model1.HIGH);
        et6.setText(model1.AVG);
        TableLayout table = (TableLayout)SecondActivity.this.findViewById(R.id.tablelay);
        Context context1=MyApp.getContext();
        Util util1=new Util(context1,"db1.db", null,1);;
        String[] str=new String[model1.nocolumn];
        str=util1.readscores();
        for(int k=0;k<model1.nocolumn;k++)
        {
            // Inflate your row "template" and fill out the fields.
            TableRow row = (TableRow) LayoutInflater.from(SecondActivity.this).inflate(R.layout.table_layout, null);
            ((TextView)row.findViewById(R.id.test1)).setText(str[k]);
            table.addView(row);
        }
        table.requestLayout();     // Not sure if this is needed.

    }

}
