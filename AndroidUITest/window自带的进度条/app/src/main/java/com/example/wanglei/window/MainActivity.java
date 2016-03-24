package com.example.wanglei.window;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

    }

    public void show(View view){
        setProgressBarIndeterminateVisibility(true);
        //setProgressBarVisibility(true);
        setProgress(5);

    }
    public void hide(View view){
        setProgressBarIndeterminateVisibility(false);
        setProgressBarVisibility(false);
    }
}
