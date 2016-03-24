package com.example.wanglei.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int[] contexts = new int[]{
            R.string.str1,R.string.str2,
            R.string.str3,R.string.str4,
            R.string.str5,R.string.str6,
            R.string.str7,R.string.str8,
            R.string.str9,R.string.str10,
    };
    int currentStr = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textview);
        final Handler handler = new Handler(){
          @Override
            public void handleMessage(Message msg){
              if (msg.what == 0x123){
                  textView.setText(contexts[currentStr++%contexts.length]);
              }
          }

        };

        //定义一个计时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,1200);
    }
}
