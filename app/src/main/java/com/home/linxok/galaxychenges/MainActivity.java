package com.home.linxok.galaxychenges;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SAVED_TEXT = "saved_text";
    private Button btnStart;
    private EditText txtEdit;
    private CheckBox chBox1;
    private CheckBox chBox2;
    private CheckBox chBox3;
    private RadioGroup radioGroup;
    private SharedPreferences sPref;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnStart = findViewById(R.id.buttonStart);
        txtEdit = findViewById(R.id.editText);
        chBox1 = findViewById(R.id.checkBox1);
        chBox2 = findViewById(R.id.checkBox2);
        chBox3 = findViewById(R.id.checkBox3);
        radioGroup = findViewById(R.id.radioGroup1);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        btnStart.setOnClickListener(this);

        loadParam();

    }

    protected void onDestroy() {

        super.onDestroy();
        saveParam();
    }

    private void loadParam() {
        sPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        txtEdit.setText(sPref.getString("GalaxyName", ""));
        chBox1.setChecked(sPref.getBoolean("Moon", false));
        chBox2.setChecked(sPref.getBoolean("Singular", false));
        chBox3.setChecked(sPref.getBoolean("Enemy", false));
        switch (sPref.getString("Size", "")){
            case "Small":
                radioGroup.check(R.id.radioButton1);
                break;
            case "Middle":
                radioGroup.check(R.id.radioButton2);
                break;
            case "Large":
                radioGroup.check(R.id.radioButton3);
                break;
                default:
                    break;
        }
        Toast.makeText(this, "Text Load", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonStart){
            saveParam();
            Intent intent = new Intent(this, ViewActivity.class);
            startActivity(intent);
        }
    }

    private void saveParam() {

        sPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("GalaxyName", String.valueOf(txtEdit.getText()));
        ed.putBoolean("Moon", chBox1.isChecked());
        ed.putBoolean("Singular", chBox2.isChecked());
        ed.putBoolean("Enemy", chBox3.isChecked());
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioButton1:
                ed.putString("Size", "Small");
                break;
            case R.id.radioButton2:
                ed.putString("Size", "Middle");
                break;
            case R.id.radioButton3:
                ed.putString("Size", "Large");
                break;

                default:
                    break;
        }
        ed.apply();
        Toast.makeText(this, "Text Saved", Toast.LENGTH_SHORT).show();

    }

}
