package com.example.wanglei.textevent1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by wanglei on 15/12/21.
 */
public class TestEvent1 extends Activity {
    private static  final  String TAG = "TestEvent1";
    public  TestEvent1(){
    }
    @Override
    public void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text1);
        final Button Button1 = (Button)findViewById(R.id.button1);
        final Button Button2 = (Button)findViewById(R.id.button2);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.RED);
                text.setBackgroundColor(Color.RED);
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void  onClick(View v){
                v.setBackgroundColor(Color.GREEN);
                text.setBackgroundColor(Color.GREEN);
            }
        });
    }

}
