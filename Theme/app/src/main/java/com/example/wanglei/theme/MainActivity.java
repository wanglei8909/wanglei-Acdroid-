package com.example.wanglei.theme;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //1.主题不能作用于单个View组件，主题应该对整个应用中的所有Activity起作用，或对指定的Activity起作用
    //2.主题定义的格式应该是改变窗口外观的格式，例如窗口标题，窗口边框等。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
