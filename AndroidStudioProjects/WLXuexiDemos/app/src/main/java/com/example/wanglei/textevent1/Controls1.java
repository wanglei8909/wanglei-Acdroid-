package com.example.wanglei.textevent1;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A gallery of basic controls: Button, EditText, RadioButton, Checkbox,
 * Spinner. This example uses the light theme.
 */
public class Controls1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls_1);

        Button disabledButton = (Button) findViewById(R.id.button_disabled);
        disabledButton.setEnabled(false);

        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
    }

    private static final String[] mStrings = {
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    };
}
