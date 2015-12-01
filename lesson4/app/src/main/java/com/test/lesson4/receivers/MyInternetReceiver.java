package com.test.lesson4.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyInternetReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {




        Log.d("RECEIVER","INTERNET изменился");

    }
}
