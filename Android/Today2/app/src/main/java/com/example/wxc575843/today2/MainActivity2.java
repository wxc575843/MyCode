package com.example.wxc575843.today2;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;

import java.lang.reflect.Method;

public class MainActivity2 extends AppCompatActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initActionBar();
        initSlidingMenu();
    }
    @SuppressLint("NewApi")
    private void initActionBar(){
        actionBar=super.getActionBar();
        actionBar.show();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.com_btn);

        actionBar.setDisplayShowCustomEnabled(true);
        TextView tvTitle=new TextView(this);
        tvTitle.setText("主  页");
        tvTitle.setTextColor(Color.WHITE);
        tvTitle.setTextSize(18);
        tvTitle.setGravity(Gravity.CENTER);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        tvTitle.setLayoutParams(params);
        actionBar.setCustomView(tvTitle);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private SlidingMenu slidingMenu;
    private void initSlidingMenu(){
        slidingMenu=new SlidingMenu(this);

        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setMenu(R.layout.menu_left_layout);
        slidingMenu.setSecondaryMenu(R.layout.navigation_layout);

        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setShadowWidth(10);
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);//设置偏离距离
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏模式，全屏滑动都可打开


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                slidingMenu.toggle();
                break;
            case R.id.usersetting:
                if(!slidingMenu.isSecondaryMenuShowing()){
                    slidingMenu.showSecondaryMenu();
                }else{
                    slidingMenu.toggle();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 实现overflow菜单项带ICON
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

}
