package com.test.dialogi;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity
        implements NoticeDialogFragment.NoticeDialogListener{

    public TextView textView_1;
    public TextView textView_2;
    public TextView textView_3;
    public StringBuilder stringBuilder;
    public int numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_1=(TextView) findViewById(R.id.textView1);
        textView_2=(TextView) findViewById(R.id.textView2);
        textView_3=(TextView) findViewById(R.id.textView3);
    }

    public void pushDialog(){
        DialogFragment dialogFragment=new NoticeDialogFragment();
        dialogFragment.show(getFragmentManager(), "NoticeDialogFragment");
    }

    public void clickTextView1(View view){
        pushDialog();
        numberTextView=1;
    }

    public void clickTextView2(View view){
        pushDialog();
        numberTextView=2;
    }

    public void clickTextView3(View view){
        pushDialog();
        numberTextView=3;
    }

    @Override
    public void onDialogPositiveClick(ArrayList<Integer> arrayList) {
        stringBuilder=new StringBuilder();
        for(int i=0;i<arrayList.size();i++)
            switch(arrayList.get(i)){
                case 0: stringBuilder.append("Stroka 1 ");
                    break;
                case 1: stringBuilder.append("Stroka 2 ");
                    break;
                case 2: stringBuilder.append("Stroka 3 ");
                    break;
            }
        switch (numberTextView){
            case 1: textView_1.setText(stringBuilder);
                break;
            case 2: textView_2.setText(stringBuilder);
                break;
            case 3: textView_3.setText(stringBuilder);
                break;
        }
    }
}
