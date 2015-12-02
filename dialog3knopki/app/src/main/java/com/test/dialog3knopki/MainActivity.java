package com.test.dialog3knopki;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity
        implements NoticeDialogFragment.NoticeDialogListener{

    NoticeDialogFragment mNoticeDialogFragment;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.buttonActivity);
    }

    public void pushDialog() {
        mNoticeDialogFragment = new NoticeDialogFragment();
        mNoticeDialogFragment.show(getFragmentManager(), "NoticeDialogFragment");
    }

    public void onClick(View view){
        pushDialog();
    }

    @Override
    public void onDialogClick(String string) {
        button.setText(string);
    }
}