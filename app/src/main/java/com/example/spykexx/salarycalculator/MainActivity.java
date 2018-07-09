package com.example.spykexx.salarycalculator;

import android.app.FragmentManager;
import android.content.Context;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Context contextOfApp;

    static ArrayList<PayStatement> listStatements = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextOfApp = this.getApplicationContext();
        listStatements.add(new PayStatement(80,14, new Deductions(1)));

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
