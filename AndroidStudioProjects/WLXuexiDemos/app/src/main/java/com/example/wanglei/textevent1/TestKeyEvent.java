package com.example.wanglei.textevent1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wanglei on 15/12/21.
 */
public class TestKeyEvent extends Activity {
    private static final String TAG = "TestKeyEvent";
    private ImageView mImage;
    private TextView mAlphavalueText;
    private int mAlphavalue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testkeyevent);
        mImage = (ImageView) findViewById(R.id.image);
        mAlphavalueText = (TextView) findViewById(R.id.alphavalue);
        mAlphavalue = 100;
        mImage.setAlpha(mAlphavalue);
        mAlphavalueText.setText("Alpha = "+mAlphavalue*100/0xff+"%");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg){
        Log.v(TAG,"onKeyDown:keyCode = "+keyCode);
        Log.v(TAG,"onKeyDown:String = "+msg.toString());

        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                mAlphavalue += 20;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                mAlphavalue -= 20;
                break;
            default:
                break;

        }
        if (mAlphavalue>=0xFF)mAlphavalue = 0xFF;
        if (mAlphavalue<=0)mAlphavalue = 0x0;
        mImage.setAlpha(mAlphavalue);
        mAlphavalueText.setText("Alpha = "+mAlphavalue*100/0xff+"%");
        return  super.onKeyDown(keyCode,msg);
    }
}
