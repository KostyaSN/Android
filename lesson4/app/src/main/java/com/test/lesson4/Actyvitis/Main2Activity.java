package com.test.lesson4.Actyvitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.test.lesson4.Adapterss.MyAdapter;
import com.test.lesson4.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private List<String> list = new ArrayList<>();
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        list.add("Элемент 1");
        list.add("Элемент 2");
        list.add("Элемент 3");
        list.add("Элемент 4");
        list.add("Элемент 5");
        list.add("Элемент 6");
        list.add("Элемент 7");
        list.add("Элемент 8");
        list.add("Элемент 9");
        list.add("Элемент 10");
        list.add("Элемент 11");
        list.add("Элемент 12");
        list.add("Элемент 13");
        list.add("Элемент 14");
        list.add("Элемент 15");


        mListView = (ListView) findViewById(R.id.listView);

        MyAdapter myAdapter = new MyAdapter(this, list);
        mListView.setAdapter(myAdapter);
    }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id){

        Toast.makeText(Main2Activity.this,""+ position, Toast.LENGTH_SHORT).show();
    }


}

