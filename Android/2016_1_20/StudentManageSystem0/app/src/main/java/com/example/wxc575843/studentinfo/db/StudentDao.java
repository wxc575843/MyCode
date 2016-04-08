package com.example.wxc575843.studentinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wxc575843.db.StudentDBOpenHelper;
import com.example.wxc575843.studentinfo.domain.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc575843 on 16/1/20.
 * 提供增删改查
 */
public class StudentDao {

    private StudentDBOpenHelper helper;

    /**
     * 没有无参的构造方法,只能用这个方法初始化
     * @param context
     */
    public StudentDao(Context context){
        helper = new StudentDBOpenHelper(context);
    }

    /**
     * 添加一个学生信息
     * @param name 姓名
     * @param phone 电话
     * @return 添加在数据库的第几行
     */
    public long add(String name, String phone){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        long rowid = db.insert("info", null, values);
        db.close();
        return rowid;
    }

    /**
     * 删除一条学生信息
     * @param id 学生id
     * @return
     */
    public long delete(String id){
        SQLiteDatabase db = helper.getWritableDatabase();
        long result = db.delete("info", "_id=?", new String[]{id});
        db.close();
        return result;
    }


    /**
     * 获取所有的学生信息
     * @return
     */
    public List<StudentInfo> findAll(){
        List<StudentInfo> infos = new ArrayList<StudentInfo>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor =  db.query("info", new String[]{"_id", "name", "phone"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            StudentInfo info = new StudentInfo();
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            info.setId(id);
            info.setName(name);
            info.setPhone(phone);
            infos.add(info);
        }
        cursor.close();
        db.close();
        return infos;
    }

}
