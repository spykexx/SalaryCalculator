package com.example.spykexx.salarycalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class options_dialog extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    CheckBox cbMarried;
    EditText etMedIns;
    EditText etLifeIns;
    EditText etFlexSpend;
    EditText etRetire;
    EditText etPostTax;
    Button butSave;
    Spinner spState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_dialog);
        etMedIns = findViewById(R.id.etMedIns);
        etLifeIns = findViewById(R.id.etLifeIns);
        etFlexSpend = findViewById(R.id.etFlexSpend);
        etRetire = findViewById(R.id.etRetire);
        etPostTax = findViewById(R.id.etPostTax);
        cbMarried = findViewById(R.id.cbMarried);
        butSave = findViewById(R.id.butSave);
        spState = findViewById(R.id.spState);
        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.spykexx.salarycalculator", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("married", false) == true){
            cbMarried.setChecked(true);
        } else {
            cbMarried.setChecked(false);
        }
        spState.setSelection(((ArrayAdapter)spState.getAdapter()).getPosition(sharedPreferences.getString("state", "Iowa")));
        etMedIns.setHint(Double.toString(Double.longBitsToDouble(sharedPreferences.getLong("medical_insurance", 0))));
        etLifeIns.setHint(Double.toString(Double.longBitsToDouble(sharedPreferences.getLong("life_insurance", 0))));
        etFlexSpend.setHint(Double.toString(Double.longBitsToDouble(sharedPreferences.getLong("flex_spending", 0))));
        etRetire.setHint(Double.toString(Double.longBitsToDouble(sharedPreferences.getLong("retirement", 0))));
        etPostTax.setHint(Double.toString(Double.longBitsToDouble(sharedPreferences.getLong("post_tax", 0))));

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbMarried.isChecked()){
                    sharedPreferences.edit().putBoolean("married", true).apply();
                } else {
                    sharedPreferences.edit().putBoolean("married", false).apply();
                }

                sharedPreferences.edit().putString("state",spState.getSelectedItem().toString()).apply();
                getDeductions();
                finish();
            }
        });
    }
    public void getDeductions(){
        if(!etMedIns.getText().toString().isEmpty()){
            sharedPreferences.edit().putLong("medical_insurance", Double.doubleToRawLongBits(Double.parseDouble(etMedIns.getText().toString()))).apply();
        }else{

        }
        if(!etLifeIns.getText().toString().isEmpty()){
            sharedPreferences.edit().putLong("life_insurance", Double.doubleToRawLongBits(Double.parseDouble(etLifeIns.getText().toString()))).apply();
        }
        if(!etFlexSpend.getText().toString().isEmpty()){
            sharedPreferences.edit().putLong("flex_spending", Double.doubleToRawLongBits(Double.parseDouble(etFlexSpend.getText().toString()))).apply();
        }
        if(!etRetire.getText().toString().isEmpty()){
            sharedPreferences.edit().putLong("retirement", Double.doubleToRawLongBits(Double.parseDouble(etRetire.getText().toString()))).apply();
        }
        if(!etPostTax.getText().toString().isEmpty()){
            sharedPreferences.edit().putLong("post_tax", Double.doubleToRawLongBits(Double.parseDouble(etPostTax.getText().toString()))).apply();
        }

    }
}
