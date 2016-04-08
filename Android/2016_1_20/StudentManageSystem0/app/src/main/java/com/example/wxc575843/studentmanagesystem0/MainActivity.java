package com.example.wxc575843.studentmanagesystem0;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wxc575843.studentinfo.db.StudentDao;
import com.example.wxc575843.studentinfo.domain.StudentInfo;

import java.util.List;

public class MainActivity extends Activity {

    private EditText et_name;
    private EditText et_phone;
    private ListView lv;
    private Button btn_add;

    private StudentDao dao;
    private List<StudentInfo> infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        et_name = (EditText)findViewById(R.id.et_name);
        et_phone = (EditText)findViewById(R.id.et_phone);
        lv = (ListView)findViewById(R.id.lv);
        btn_add = (Button)findViewById(R.id.btn_add);
        dao = new StudentDao(this);
        infos=dao.findAll();
        lv.setAdapter(new StudentAdapter());
    }

    public void add(View view){
        String name = et_name.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
            Toast.makeText(this,"数据不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        long result = dao.add(name,phone);
        if(result > 0 ){
            Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
            infos=dao.findAll();
            lv.setAdapter(new StudentAdapter());
        }else{
            Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
        }

    }

    public class StudentAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return infos.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(MainActivity.this,R.layout.item,null);
            TextView tv_id =(TextView) view.findViewById(R.id.tv_id);
            TextView tv_name =(TextView)view.findViewById(R.id.tv_name);
            TextView tv_phone =(TextView)view.findViewById(R.id.tv_phone);
            tv_id.setText(infos.get(position).getId());
            tv_name.setText(infos.get(position).getName());
            tv_phone.setText(infos.get(position).getPhone());
            return view;

//            TextView tv;
//            if(convertView == null){
//                tv = new TextView(MainActivity.this);
//            }else{
//                tv=(TextView)convertView;
//            }
//            tv.setTextSize(20);
//            tv.setTextColor(Color.RED);
//            tv.setText(infos.get(position).toString());
//            return tv;
        }
    }
}
