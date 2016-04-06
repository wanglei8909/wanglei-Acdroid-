package com.example.wanglei.drawtextonpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TestView(this));
    }

    class TestView extends View{
        final String DRAW_STR = "我的键盘什么时候能到啊";
        Path[] paths = new Path[3];
        Paint paint;
        public TestView(Context context)
        {
            super(context);
            paths[0] = new Path();
            paths[0].moveTo(0,0);
            for (int i = 0; i<=20;i++)
            {
                paths[0].lineTo(i*30,(float)Math.random());
            }
            paths[1] = new Path();
            RectF rectF = new RectF(0,0,600,360);
            paths[1].addOval(rectF,Path.Direction.CCW);
            paths[2] = new Path();
            paths[2].addArc(rectF,60,180);

            //画笔
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.CYAN);
            paint.setStrokeWidth(1);
        }
        @Override
        protected void onDraw(Canvas canvas)
        {
            canvas.drawColor(Color.WHITE);
            canvas.translate(40, 40);
            //设置从右开始绘制（右对齐）
            paint.setTextSize(20);
            paint.setStyle(Paint.Style.STROKE);
            //绘制路径
            canvas.drawPath(paths[0], paint);
            paint.setTextSize(40);
            //沿着路径绘制一段文本
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR, paths[0], -8, 20, paint);
            //对Canvas进行坐标变换，画布下移60
            canvas.translate(0, 60);
            //绘制路径
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[1], paint);
            //沿着路径绘制一段文本
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR, paths[1], -20, 20, paint);
            //对Canvas进行坐标变换：画布下移360
            canvas.translate(0, 360);
            //绘制路径
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[2],paint);
            //沿着路径绘制一段文本
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STR,paths[2],-10,20,paint);
        }
    }
}



