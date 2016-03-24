package com.example.wanglei.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void normal (View view){
        Toast toast = Toast.makeText(MainActivity.this,"简单的提示信息",Toast.LENGTH_LONG);
        toast.show();
    }
    public void imageToast (View view){
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ImageView image = new ImageView(MainActivity.this);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setLayoutParams(new LinearLayout.LayoutParams(320, 320));
        image.setImageResource(R.drawable.img1);

        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.addView(image);
        ll.setOrientation(1);

        TextView textView = new TextView(MainActivity.this);
        textView.setText("带图片的提示信息");
        textView.setTextSize(14);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        ll.addView(textView);
        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }

}
