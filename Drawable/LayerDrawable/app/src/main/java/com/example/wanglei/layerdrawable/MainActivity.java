package com.example.wanglei.layerdrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar bar = (SeekBar)findViewById(R.id.seekbar);
        bar.setProgress(50);
    }
}
