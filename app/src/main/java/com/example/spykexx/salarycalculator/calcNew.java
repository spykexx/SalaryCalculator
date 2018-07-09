package com.example.spykexx.salarycalculator;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class calcNew extends AppCompatActivity {

    CheckBox cbOT;
    EditText etRegHours;
    EditText etRegPay;
    EditText etOTHours;
    EditText etOTPay;
    GridLayout glOT;
    Button butSubmit;
    Button butOptions;
    PayStatement payStatement;
    SharedPreferences sharedPreferences;
    Deductions deductions;
    salaryDialog sd = new salaryDialog();
    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    public static Context contextOfApp;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.settings:
                Log.i("Item Selected ", "Settings");
                break;
            default:
                return false;
        }
        return true;
    }
    public PayStatement getUserInput(){

        if(cbOT.isChecked()){
            if(etOTPay.getText().toString().matches("") || etOTHours.getText().toString().matches("") || etRegPay.getText().toString().matches("") || etRegHours.getText().toString().matches("")) {
                /*
                If one field is empty and checkbox is checked, clear the object from previous transaction and alert the user
                 */
                payStatement.clearAll();
                Toast.makeText(calcNew.this, "Please fill all fields in!", Toast.LENGTH_SHORT).show();
            }else { //pass regular and overtime hours and payrate into paystatement object
                deductions = new Deductions(1);
                payStatement = new PayStatement(Double.parseDouble(etRegHours.getText().toString()), Double.parseDouble(etRegPay.getText().toString()), Double.parseDouble(etOTHours.getText().toString()), Double.parseDouble(etOTPay.getText().toString()), deductions);


                sd.onDismiss(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });
                sd.show(fm, "Salary");
            }
        } else {
            if (etRegPay.getText().toString().matches("") || etRegHours.getText().toString().matches("")) {
                /*
                If the checkbox is NOT checked, and one field is empty, clear previous transaction and alert the user.
                 */
                payStatement.clearAll();
                Toast.makeText(calcNew.this, "Please fill all fields in!", Toast.LENGTH_SHORT).show();
            } else { //Pass in regular hours and payrate to paystatement object\
                deductions = new Deductions(1);
                payStatement = new PayStatement(Double.parseDouble(etRegHours.getText().toString()), Double.parseDouble(etRegPay.getText().toString()), deductions);
                sd.show(fm, "Salary");
                fm.executePendingTransactions();
                sd.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        finish();
                    }
                });

            }
        }
        return payStatement;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_new);
        payStatement = new PayStatement();
        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.spykexx.salarycalculator", Context.MODE_PRIVATE);
        cbOT = findViewById(R.id.cbOT);
        etRegHours = findViewById(R.id.etRegHours);
        etRegPay = findViewById(R.id.etRegPay);
        etOTHours = findViewById(R.id.etOTHours);
        etOTPay = findViewById(R.id.etOTPay);
        glOT = findViewById(R.id.glOTGrid);
        butSubmit = findViewById(R.id.butSubmit);
        butOptions = findViewById(R.id.butOption);
        contextOfApp = getApplicationContext();
        /*
        what to do on click of calculate. getUserInput pulls information from the editTexts.
         */
        butOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calcNew.this, options_dialog.class);
                startActivity(intent);
            }
        });
        butSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserInput();
                Log.i("Total: ", payStatement.toString());
                //Toast.makeText(MainActivity.this, payStatement.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        /*
        What happens when the checkbox is clicked. The overtime section is removed, and the button moves upwards.
         */
        cbOT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbOT.isChecked()){
                    glOT.setVisibility(View.VISIBLE);
                } else {
                    glOT.setVisibility(View.GONE);
                }
            }
        });


    }
    public static Context getContextOfApp(){
        return contextOfApp;
    }
    public PayStatement getPayStatement(){
        return payStatement;
    }
    public void checkFirstRun(){
        if(sharedPreferences.getBoolean("First_Run", true)){
            sharedPreferences.edit().putBoolean("First_Run", false);
        }
    }
}
