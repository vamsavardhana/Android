package com.example.anna.assignment3parta.model;

import java.io.Serializable;

/**
 * Created by anna on 3/27/16.
 */
public class Model implements Serializable{
    public static String LOW;
    public static String HIGH;
    public static String AVG;
    public static int nocolumn;
    public void setLOW(String str){
        this.LOW=str;
    }
    public void setHIGH(String str){
        this.HIGH=str;
    }
    public void setAVG(String str){
        this.AVG=str;
    }
    public void setnocolumn(int nocolumn){
        this.nocolumn=nocolumn;
    }

}
