package com.example.wanglei.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto;
    MultiAutoCompleteTextView mauto;
    String[] dabians = new String[]{
            "大黄色大便",
            "大红色大便",
            "大黑色大便",
            "大绿色大便",
            "大干屎",
            "大稀屎",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,dabians);
        auto = (AutoCompleteTextView)findViewById(R.id.auto);
        auto.setAdapter(aa);

        mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
