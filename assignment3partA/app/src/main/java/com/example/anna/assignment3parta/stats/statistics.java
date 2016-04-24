package com.example.anna.assignment3parta.stats;
import android.content.Context;
import android.util.Log;

import com.example.anna.assignment3parta.MyApp;
import com.example.anna.assignment3parta.Util.Util;

import java.util.Arrays;

public class statistics extends Average implements findLowfunction,findHighfunction{
Util util2;
    //Function to find lowest score in each test
    public void findLow(Student[] students) {
        Context context1= MyApp.getContext();
        Util util2=new Util(context1,"db1.db", null,1);
       }

    //Function to find Highest score in all the tests for the students
    public void findHigh(Student[] students) {
        int[] Scores = new int[5];
        int[] t1 = new int[40];
        int[] t2 = new int[40];
        int[] t3 = new int[40];
        int[] t4 = new int[40];
        int[] t5 = new int[40];
        for (int i = 0; i < 40; i++) {
            if (students[i] != null) {
                Scores = students[i].getScores();
                t1[i] = Scores[0];
                t2[i] = Scores[1];
                t3[i] = Scores[2];
                t4[i] = Scores[3];
                t5[i] = Scores[4];
            }
        }
        Arrays.sort(t1);
        Arrays.sort(t2);
        Arrays.sort(t3);
        Arrays.sort(t4);
        Arrays.sort(t5);

        Log.i("HIGHSDCORESL", "the High scores are " + t1[39] + "\t" + t2[39] + "\t" + t3[39] + "\t" + t4[39] + "\t" + t5[39]);
    }

    //Function to find the average scores for each test
    public void findAverage(Student[] student) {
        int[] Scores = new int[5];
        int[] t1 = new int[15];
        int[] t2 = new int[15];
        int[] t3 = new int[15];
        int[] t4 = new int[15];
        int[] t5 = new int[15];
        int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
        int avg1, avg2, avg3, avg4, avg5;
        for (int i = 0; i < 15; i++)
        {
            if (student[i] != null)
            {
                Scores = student[i].getScores();
                t1[i] = Scores[0];
                t2[i] = Scores[1];
                t3[i] = Scores[2];
                t4[i] = Scores[3];
                t5[i] = Scores[4];
            }
        }
        for (int i = 0; i < 15; i++) {
            sum1 = sum1 + t1[i];
            sum2 = sum2 + t2[i];
            sum3 = sum3 + t3[i];
            sum4 = sum4 + t4[i];
            sum5 = sum5 + t5[i];
        }
        avg1 = sum1 / 15;
        avg2 = sum2 / 15;
        avg3 = sum3 / 15;
        avg4 = sum4 / 15;
        avg5 = sum5 / 15;
        Log.i("averages","the averages are \t" + avg1 + "\t" + avg2 + "\t" + avg3 + "\t" + avg4 + "\t" + avg5);
    }
}