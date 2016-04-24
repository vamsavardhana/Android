package com.example.anna.assignment3parta.Except;

import android.util.Log;

/**
 * Created by anna on 3/26/16.
 */
public class Greater40RecordsException extends Throwable {
    public Greater40RecordsException()
    {
        Log.i("Exception","There are greater than 40 records in this application");
    }
}
