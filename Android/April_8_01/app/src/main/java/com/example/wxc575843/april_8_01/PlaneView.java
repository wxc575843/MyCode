package com.example.wxc575843.april_8_01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by wxc575843 on 16/4/8.
 */
public class PlaneView extends View{

    public float currentX;
    public float currentY;
    Bitmap plane;
    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
        setFocusable(true);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint=new Paint();
        canvas.drawBitmap(plane,currentX,currentY,paint);
    }
}
