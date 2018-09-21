package com.home.linxok.galaxychenges;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ViewActivity extends AppCompatActivity {

    private SharedPreferences sPref;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);



        StringBuffer stringBuffer = new StringBuffer();

        sPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        stringBuffer.append("GalaxyName: "+ sPref.getString("GalaxyName", "")+"\n");
        stringBuffer.append("Moon: "+ sPref.getBoolean("Moon", false)+"\n");
        stringBuffer.append("Singular: "+sPref.getBoolean("Singular", false)+"\n");
        stringBuffer.append("Enemy: "+sPref.getBoolean("Enemy", false)+"\n");
        stringBuffer.append("Size: "+  sPref.getString("Size", "")+"\n");

        textView = findViewById(R.id.textViewend);
        textView.setText(stringBuffer.toString());
    }
}
