package com.example.wanglei.handdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wanglei on 16/4/6.
 */
public class DrawView extends View {
    //定义记录前一个拖动时间发生点的坐标
    float preX;
    float preY;
    private Path path;
    public Paint paint = null;
    //定义内存中的一个图片，该图片将作为缓冲区
    Bitmap cacheBitmap = null;
    //定义cacheBitmap上的Canvas对象
    Canvas cacheCanvas = null;
    public DrawView(Context context,int width,int height)
    {
        super(context);
        //创建一个与该View具有相同大小的缓冲区域
        cacheBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        path = new Path();
        //设置cacheCanvas将会绘制到内存中的cacheBitmap上
        cacheCanvas.setBitmap(cacheBitmap);
        //设置画笔的颜色
        paint = new Paint(Paint.DITHER_FLAG);
        paint.setColor(Color.RED);
        //设置画笔风格
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        //反锯齿
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //获取拖动事件的发生位置
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //从上一个点绘制到当前点之后，把当前点定义成下次绘制的前一个点
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path, paint);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        Paint bmpPaint = new Paint();
        //将cacheBitmap绘制到该view组件上
        canvas.drawBitmap(cacheBitmap,0,0,bmpPaint);
        canvas.drawPath(path,paint);
    }
}




















