package com.example.wanglei.plaingame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by wanglei on 16/3/23.
 */
public class PlainView extends View {
    public float currentX;
    public float currentY;
    Bitmap plain;
    public PlainView(Context context){
        super(context);
        plain = BitmapFactory.decodeResource(context.getResources(),R.drawable.plain);
        setFocusable(true);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //创建画笔
        Paint p = new Paint();
        canvas.drawBitmap(plain,currentX,currentY,p);
    }
}
