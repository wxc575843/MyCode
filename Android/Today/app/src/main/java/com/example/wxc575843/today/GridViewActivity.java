package com.example.wxc575843.today;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.wxc575843.today.GridView;

public class GridViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);

        ((GridView) findViewById(R.id.gridview))
                .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.stringarray)));
    }

}
