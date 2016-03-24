package com.example.wanglei.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView sv;
    private ListView lv;

    private final String[] mStrings = {"aaaaa","bbbbbbb","cccccc","dddddddd"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mStrings));
        lv.setTextFilterEnabled(true);

        sv = (SearchView)findViewById(R.id.searchview);
        //设置 默认是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        //设置 显示搜说按钮
        sv.setSubmitButtonEnabled(true);
        //设置默认提示文本
        sv.setQueryHint("查找");
        //设置监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"您的选择是："+query,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    lv.clearTextFilter();
                }
                else {
                    lv.setFilterText(newText);
                }
                return false;
            }
        });
    }
}
