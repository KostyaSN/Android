package com.test.widget.Widgets;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class WidService extends android.app.Service {

    public static final String ACTION="action";
    public static final int ACTION_BT=1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int action = intent.getIntExtra(ACTION, -1);
        switch(action){
            case 1:
                Log.d("case", "blut");
                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if(bluetoothAdapter.isEnabled()){bluetoothAdapter.disable();}
                else {bluetoothAdapter.enable();}
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
