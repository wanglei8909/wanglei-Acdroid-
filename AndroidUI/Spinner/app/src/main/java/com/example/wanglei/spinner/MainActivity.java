package com.example.wanglei.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);

        final String[] arr = new String[]{
            "唐僧","孙悟空","猪八戒","沙悟净"
        };
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arr.length;
            }

            @Override
            public Object getItem(int position) {
                return arr[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LinearLayout line = new LinearLayout(MainActivity.this);
                line.setOrientation(0);
                TextView textView = new TextView(MainActivity.this);
                textView.setTextSize(20);
                textView.setText(arr[position]);
                textView.setPadding(16,0,0,0);
                line.addView(textView);
                return line;
            }
        };
        spinner.setAdapter(adapter);

    }
}
