package com.example.anna.assignment3partb;

import android.app.Application;
import android.content.Context;

/**
 * Created by anna on 3/31/16.
 */
public class MyApp extends Application {
    private static MyApp instance;
    public static MyApp getInstance(){return instance;}
    public static Context getContext(){
        return instance;
    }
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
