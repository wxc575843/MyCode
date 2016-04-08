package com.example.wxc575843.a2016_04_04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by wxc575843 on 16/4/4.
 */
public class DrawView extends View {

    public float cx=40;
    public float cy=50;
    public DrawView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(cx,cy,20,paint);
    }
}
