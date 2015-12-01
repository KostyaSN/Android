package com.test.lesson4.Actyvitis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.lesson4.R;

public class MainActivity extends Activity {


    private EditText mEditText;
    private static final String KEY_EDIT_TEXT = "KEY_EDIT_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button button =(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main22Activity.class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String text = sharedPreferences.getString(KEY_EDIT_TEXT, "");

        mEditText.setText(text);
    }


    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        if (!TextUtils.isEmpty(mEditText.getText())) {// проверяем есть ли текст

            sharedPreferences.edit().putString(KEY_EDIT_TEXT,
                    String.valueOf(mEditText.getText())).apply();
            String text = sharedPreferences.getString(KEY_EDIT_TEXT, "");
        }
    }


}


