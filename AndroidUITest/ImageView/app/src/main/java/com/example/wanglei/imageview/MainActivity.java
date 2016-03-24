package com.example.wanglei.imageview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
    };
    int currentImage = 2;
    protected int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button plus = (Button)findViewById(R.id.btn1);
        final Button minus = (Button)findViewById(R.id.btn2);
        final ImageView image1 = (ImageView)findViewById(R.id.image1);
        final ImageView image2 = (ImageView)findViewById(R.id.image2);
        final Button next = (Button)findViewById(R.id.btn3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImage % images.length]);
            }
        });

        View.OnClickListener listerner = new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if (v == plus){
                    alpha += 20;
                }
                if (v == minus){
                    alpha -= 20;
                }
                if (alpha >= 255){
                    alpha = 255;
                }
                if (alpha <= 0){
                    alpha = 0;
                }
                image1.setImageAlpha(alpha);
            }
        };
        plus.setOnClickListener(listerner);
        minus.setOnClickListener(listerner);
        image1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event){
                BitmapDrawable bitmapDrawable = (BitmapDrawable)image1.getDrawable();
                //获取第一个显示框中的位图
                Bitmap bitmap = bitmapDrawable.getBitmap();
                //bitmap图片实际大小与第一个 ImageView的缩放比例
                double scale = 1.0 * bitmap.getHeight()/image1.getHeight();
                //获取需要显示的图片的起始点
                int x = (int)(event.getX() * scale);
                int y = (int)(event.getY() * scale);
                if (x + 120 > bitmap.getWidth()){
                    x = bitmap.getWidth() - 120;
                }
                if (y + 120 >bitmap.getHeight()){
                    y = bitmap.getHeight() - 120;
                }
                //显示图片的指定区域
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setImageAlpha(alpha);
                return  false;
            }
        });
    }
}
