package com.example.wanglei.textevent1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by wanglei on 15/12/21.
 */
public class TestMotionEvent extends Activity{
    private static final String TAG = "TestMotionEvent";
    TextView mAction;
    TextView mPostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmotionevent);
        mAction = (TextView) findViewById(R.id.action);
        mPostion = (TextView) findViewById(R.id.postion);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int Action = event.getAction();
        float X = event.getX();
        float Y = event.getY();
        Log.v(TAG,"Action = "+Action );
        Log.v(TAG,"("+X+","+Y+")");
        mAction.setText("Action = "+Action);
        mPostion.setText("Postion = ("+X+","+Y+")");
        return true;
    }
}
