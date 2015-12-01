package com.test.lesson4.Actyvitis;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.test.lesson4.Adapterss.SummaAdepter;
import com.test.lesson4.Models.Summa;
import com.test.lesson4.R;
import com.test.lesson4.receivers.MyInternetReceiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main22Activity extends AppCompatActivity {

    private List<Summa> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SummaAdepter mSummaAdepter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    //    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);// добавляется при том что мы точно знаем размеры того что будет создаваться, пишется для ускорение работы

        mSummaAdepter = new SummaAdepter(mList);
        mRecyclerView.setAdapter(mSummaAdepter);

        mSummaAdepter.setmItemClickListener(new SummaAdepter.ItemClickListener() {
            @Override
            public void onClick(Summa summa) {
                Log.d("ResVIEW", "item name" + summa.getName());
                Toast.makeText(getApplicationContext(),summa.getName(),Toast.LENGTH_SHORT).show();

                //привязываем свой локальны бродкаст менеджер на клик
                LocalBroadcastManager.getInstance(Main22Activity.this).sendBroadcast(new Intent(ACTION_MY));
            }
        });

        showDate();

    }

    private void showDate(){
        mList.add(new Summa(10, new Date(), "Первый"));
        mList.add(new Summa(5.5, new Date(), "Второй"));
        mList.add(new Summa(10.3, new Date(), "Третий"));
        mList.add(new Summa(1.4, new Date(), "Четвертый"));
        mList.add(new Summa(1.9, new Date(), "Пятый"));
        mList.add(new Summa(13, new Date(), "Первый 12"));
        mList.add(new Summa(17, new Date(), "Первый 412"));
        mList.add(new Summa(102, new Date(), "Первый 12"));
        mList.add(new Summa(1023, new Date(), "Первый 22"));
        mList.add(new Summa(10123, new Date(), "Первый 4"));

        mSummaAdepter.addItems(mList);

    }

//  /  private MyInternetReceiver myInternetReceiver;

public static final String ACTION_MY="com.test.lesson4.Actyvitis";

    @Override
    protected void onResume() {// при открытой активити
        super.onResume();
//        myInternetReceiver = new MyInternetReceiver();
//        IntentFilter intentFilter = new IntentFilter();//подключаем проверку состояния сети
//        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);//статус интернета
//        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);//статус блютуза
//        registerReceiver(broadcastReceiver, intentFilter);

        IntentFilter intentFilterLocal = new IntentFilter();
        intentFilterLocal.addAction(ACTION_MY);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiverLocal, intentFilterLocal);

    }

    @Override
    protected void onPause() {//при паузе
        super.onPause();

//        unregisterReceiver(broadcastReceiver);//отключаем проверку состояния интернета
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiverLocal);

    }

            BroadcastReceiver broadcastReceiverLocal = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d("RECEIVER","broadcastReceiverLocal сработал");
                }
            };


//    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {//абстрактный класс для определения состояния интернета
//        @Override
//
//            public void onReceive(Context context, Intent intent) {
//
//          //  String action = intent.getAction();
//
//            int state  = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,-1);//получаем инт значение статуса интернета
//
//            Log.d("RECEIVER","INTERNET изменился");
//
//            Log.d("RECEIVER","bluetooth изменился");
//
//            Log.d("RECEIVER", String.valueOf(state));
//
//            if (state == BluetoothAdapter.STATE_ON)//сверяем полученное значени state c числом которое соответсвует статусу блютуза
//            {
//                Log.d("RECEIVER","bluetooth STATE_ON");
//            }
//            else if (state == BluetoothAdapter.STATE_OFF)
//            {
//                Log.d("RECEIVER","bluetooth STATE_OFF");
//            }else if (state == BluetoothAdapter.STATE_CONNECTING)
//            {
//                Log.d("RECEIVER","bluetooth STATE_CONNECTING");
//            }
//            else if (state == BluetoothAdapter.STATE_DISCONNECTING)
//            {
//                Log.d("RECEIVER","bluetooth STATE_DISCONNECTING");
//            }else if (state == BluetoothAdapter.STATE_CONNECTED){
//                Log.d("RECEIVER","bluetooth STATE_CONNECTED");
//            }
//            else if (state == BluetoothAdapter.STATE_DISCONNECTED)
//            {Log.d("RECEIVER","bluetooth STATE_DISCONNECTED");}
//            }
//
//    };

}

