package com.example.wxc575843.april_8_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private int speed=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlaneView planeView=new PlaneView(this);
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.back);
        WindowManager windowManager=getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        int screenWidth=display.getWidth();
        int screenHeight=display.getHeight();
        planeView.currentX=screenWidth/2;
        planeView.currentY=screenHeight/2;
        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode())
                {
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        planeView.currentY+=speed;
                        break;
                    case KeyEvent.KEYCODE_DPAD_UP:
                        planeView.currentY-=speed;
                        break;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        planeView.currentX-=speed;
                        break;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        planeView.currentX+=speed;
                        break;
                }
                planeView.invalidate();
                return true;
            }
        });
    }
}
