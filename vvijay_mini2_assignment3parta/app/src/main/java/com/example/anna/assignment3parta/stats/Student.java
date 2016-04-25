package com.example.anna.assignment3parta.stats;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
    private int SID;
    private int scores[] = new int[5];

    public int getSID()
    {
        return SID;
    }

    public void setSID(int sID) {
        SID = sID;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student SID=" + SID + ", scores=" + Arrays.toString(scores) + "\n";
    }
}