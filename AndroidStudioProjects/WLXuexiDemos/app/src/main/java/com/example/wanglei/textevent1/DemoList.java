package com.example.wanglei.textevent1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by wanglei on 15/12/22.
 */
public class DemoList extends ListActivity {
    private static final String TAG = "DemoList";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use an existing ListAdapter that will map an array
        // of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        getListView().setTextFilterEnabled(true);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.v(TAG,l.toString()+"\n"+v.toString()+"\n"+position+"\n"+id);
        Intent intent = new Intent();

        // 下面这个函数 需要一个类名  我需要通过 字符串生成一个类名


        switch (position){
            case 0:{
                intent.setClass(DemoList.this, TestEvent1.class);break;
            }
            case 1:{
                intent.setClass(DemoList.this, TestEvent2.class);break;
            }
            case 2:{
                intent.setClass(DemoList.this, TestEvent3.class);break;
            }
            case 3:{
                intent.setClass(DemoList.this, TestKeyEvent.class);break;
            }
            case 4:{
                intent.setClass(DemoList.this, TestMotionEvent.class);break;
            }
            case 5:{
                intent.setClass(DemoList.this, TestMotionEvent2.class);break;
            }
            case 6:{
                intent.setClass(DemoList.this, Forwarding.class);break;
            }
            case 7:{
                intent.setClass(DemoList.this, TestMenu.class);break;
            }
            case 8:{
                intent.setClass(DemoList.this, AlertDialogSamples.class);break;
            }
            case 9:{
                intent.setClass(DemoList.this, Controls1.class);break;

            }
            default: break;

        }

        startActivity(intent);
        finish();
    }
    private String[] mStrings = {
            "TestEvent1","TestEvent2","TestEvent3","TestKeyEvent","TestMotionEvent",
            "TestMotionEvent2","ForWarding","TestMenu","AlertDialogSamples","Controls1"
    };
}
