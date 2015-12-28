package com.example.wanglei.textevent1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

/**
 * Created by wanglei on 15/12/21.
 */
public class TestEvent3 extends Activity{
    private  static  final String TAG = "TestEvent3";
    private TextView mText;
    private Button1_OnClickListener mListener1 = new Button1_OnClickListener();
    private Button2_OnClickListener mListener2 = new Button2_OnClickListener();

    public  TestEvent3(){
    }

    class  Button1_OnClickListener implements OnClickListener {
        public void onClick(View v) {
            mText.setBackgroundColor(Color.RED);
        }
    }
    class  Button2_OnClickListener implements  OnClickListener {
        public void onClick(View v) {
            mText.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public  void  onCreate(Bundle savedInstanceStante) {
        super.onCreate(savedInstanceStante);
        setContentView(R.layout.activity_main);
        mText = (TextView)findViewById(R.id.text1);
        final Button mButton1 = (Button) findViewById(R.id.button1);
        final Button mButtin2 = (Button) findViewById(R.id.button2);

        mButton1.setOnClickListener(mListener1);
        mButtin2.setOnClickListener(mListener2);
    }
}
