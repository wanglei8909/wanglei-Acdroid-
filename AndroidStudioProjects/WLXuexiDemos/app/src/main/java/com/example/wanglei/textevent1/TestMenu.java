package com.example.wanglei.textevent1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Created by wanglei on 15/12/22.
 */
public class TestMenu extends Activity {

    private static final  String TAG = "TestMenu";
    private Button mButton;

    public static final int RED_MENU_ID = Menu.FIRST;
    public static final int GREEN_MENU_ID = Menu.FIRST +1;
    public static final int BLUE_MENU_ID = Menu.FIRST +2;
    public TestMenu(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmenu);
        mButton = (Button) findViewById(R.id.color_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0, RED_MENU_ID,    0, R.string.red);
        menu.add(0, GREEN_MENU_ID,  0, R.string.green);
        menu.add(0, BLUE_MENU_ID,   0, R.string.blue);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case RED_MENU_ID:
                mButton.setBackgroundColor(Color.RED);
                mButton.setText(R.string.red);
                return true;
            case GREEN_MENU_ID:
                mButton.setBackgroundColor(Color.GREEN);
                mButton.setText(R.string.green);
                return true;
            case BLUE_MENU_ID:
                mButton.setBackgroundColor(Color.BLUE);
                mButton.setText(R.string.blue);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
