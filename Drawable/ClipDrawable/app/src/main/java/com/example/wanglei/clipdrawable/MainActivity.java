package com.example.wanglei.clipdrawable;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageview = (ImageView)findViewById(R.id.image);
        //获取图片所显示的drawable对象
        final ClipDrawable drawable = (ClipDrawable)imageview.getDrawable();
        drawable.setLevel(0);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                if (msg.what == 0x123){
                    drawable.setLevel(drawable.getLevel() + 20);
                }
            }
        };

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x123;
                handler.sendMessage(msg);

                if (drawable.getLevel() >= 10000){
                    timer.cancel();
                }
            }
        },0,50);
    }
}
