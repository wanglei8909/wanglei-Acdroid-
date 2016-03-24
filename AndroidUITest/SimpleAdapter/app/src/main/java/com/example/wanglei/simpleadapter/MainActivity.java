package com.example.wanglei.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{
            "虎头","李白","李清照","大妞"
    };
    private String[] descs = new String[]{
            "虎头的描述","李白的描述的描述","李清照的描述的描述","大妞的描述的描述的描述"
    };
    private int[] images = new int[]{
            R.drawable.green,R.drawable.red,R.drawable.white,R.drawable.red
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("header",images[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[]{"personName","header","desc"},
                new  int[] {R.id.name,R.id.header,R.id.desc});
        ListView list = (ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]+"''''"+id);
            }
        });
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                System.out.print(position);
                System.out.print(id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
