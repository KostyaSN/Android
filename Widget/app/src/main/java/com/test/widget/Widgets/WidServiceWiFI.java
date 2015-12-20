package com.test.widget.Widgets;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class WidServiceWiFI extends android.app.Service {

    public static final String ACTION="action";
    public static final int ACTION_BT=1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int action = intent.getIntExtra(ACTION, -1);
        switch (action){
            case 1:
                Log.d("case", "wifi");
                WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                if(wifiManager.isWifiEnabled()){wifiManager.setWifiEnabled(false);
                    Log.d("case", "wifi off");}
                else{wifiManager.setWifiEnabled(true);
                    Log.d("case", "wifi onn");}
                break;

        }
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
