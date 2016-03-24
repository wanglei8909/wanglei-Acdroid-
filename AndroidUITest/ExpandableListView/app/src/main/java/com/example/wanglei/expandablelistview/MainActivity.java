package com.example.wanglei.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //创建一个 BaseExpandableAdapter
        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {


            private String[] armTypes = new String[]{
                    "神族兵种",
                    "虫族兵种",
                    "人族兵种",
            };
            private String[][] arms = new String[][] {
                    {"狂战士","龙骑士","黑暗生堂","电兵"},
                    {"小狗","刺蛇","飞龙","自暴飞机"},
                    {"机枪兵","护士MM","幽灵"}
            };

            private int[] logos = new int[]{
                    R.drawable.white,
                    R.drawable.green,
                    R.drawable.red,
            };

            @Override
            //获取指定组，指定位置的列表项处的数据
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }
            @Override
            public int getGroupCount() {
                return arms.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }
            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }
            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(0);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                linearLayout.addView(imageView);
                ViewGroup.LayoutParams lp = imageView.getLayoutParams();
                lp.height = 64;
                lp.width = 64;
                imageView.setLayoutParams(lp);

                TextView textView = getTextView();
                textView.setText(armTypes[groupPosition]);
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(arms[groupPosition][childPosition]);
                return textView;
            }

            public TextView getTextView(){
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,84);
                TextView textView = new TextView(MainActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
        };
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
