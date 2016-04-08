package com.example.wxc575843.listview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_container;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_container = (LinearLayout)findViewById(R.id.ll_container);
    }

    public void click(View view){
        TextView tv = new TextView(this);
        tv.setTextSize(20);
        tv.setText("我是第"+count+"被生出来的");
        count++;
        ll_container.addView(tv);
    }
}
