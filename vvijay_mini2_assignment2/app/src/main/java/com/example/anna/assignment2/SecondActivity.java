package com.example.anna.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anna.model.Model;
import com.example.anna.util.Util;

import java.util.StringTokenizer;

import static java.lang.Math.pow;

/**
 * Created by anna on 3/17/16.
 */
public class SecondActivity extends Activity{
    TextView tv3,tv4;
    Model model1;
    Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        TextView et2=(TextView)findViewById(R.id.tv2);
        TextView et4=(TextView)findViewById(R.id.tv4);
        TextView et6=(TextView)findViewById(R.id.tv6);
        Intent i=getIntent();
        model1=(Model)i.getSerializableExtra("modelobject");
        util=new Util(this,"db1.db",null,1);
        util.addModel(model1);
        String check=util.dBtoString();
        Log.i("check1", check);
        StringTokenizer st = new StringTokenizer(check," ");
        int purchaseprice1 = Integer.parseInt(st.nextToken()); //will parse out the first number
        int downpayment1 = Integer.parseInt(st.nextToken());
        int mortgageterm1= Integer.parseInt(st.nextToken());
        int interestrate1 = Integer.parseInt(st.nextToken());
        int propertytax1= Integer.parseInt(st.nextToken());
        int propertyinsurance1= Integer.parseInt(st.nextToken());
//        int zipcode1 = Integer.parseInt(st.nextToken());
        Log.i("check2",(purchaseprice1+" "+downpayment1+" "+mortgageterm1+ " "+interestrate1+" "+propertyinsurance1+" "+propertytax1+" "));
        double c=(double)interestrate1/100;
        Log.i("check24",c+" ");
        double monthlyRate = c/12;
        Log.i("check25",monthlyRate+" ");
        int termInMonths = mortgageterm1* 12;
        Log.i("check26",termInMonths+" ");
        double monthlyPayment =
                (purchaseprice1*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));
        Log.i("check27",((double)purchaseprice1)*monthlyRate+" ");
        Log.i("check28",1-Math.pow(1+monthlyRate, -termInMonths)+" ");
        String mp1=(int)monthlyPayment+" ";
        Log.i("monthlyPayment",mp1);
        et2.setText(mp1);
        int totalPayment=0;
        totalPayment=totalPayment+purchaseprice1+(int)c*purchaseprice1+propertyinsurance1+propertytax1;
        String totalpayment1=totalPayment+" ";
        Log.i("totalpayment",totalpayment1);
        et4.setText(totalpayment1);
        int payoffyear=Integer.parseInt(model1.selectedYear)+mortgageterm1;
        String payoffyear1=model1.selectedMonth+" "+payoffyear+" ";
        et6.setText(payoffyear1);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
