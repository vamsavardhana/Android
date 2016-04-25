package com.example.anna.assignment3parta;

import android.app.Application;
import android.content.Context;

/**
 * Created by anna on 3/26/16.
 */
public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
        // or return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}