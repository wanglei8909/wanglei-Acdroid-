package com.example.wanglei.plaingame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlainView plainView = new PlainView(MainActivity.this);
        setContentView(plainView);
        //plainView.setBackgroundResource(R.drawable.back);
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        //获取屏幕宽高
        display.getMetrics(metrics);
        //设置飞机的初始位置
        //plainView.setBackgroundColor(getResources().getColor(R.color.red));
        plainView.currentX = metrics.widthPixels/2;
        plainView.currentY = metrics.heightPixels-40;

        plainView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //判断是哪个键触发事件
                switch (event.getKeyCode()){
                    case KeyEvent.KEYCODE_S:
                        plainView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        plainView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        plainView.currentX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        plainView.currentX += speed;
                        break;
                }
                //通知组件重绘
                plainView.invalidate();
                return true;
            }
        });

    }
}
