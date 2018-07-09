package com.example.spykexx.salarycalculator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Spykexx on 6/10/2018.
 */

public class Deductions {
    double medIns;
    double lifeIns;
    double flexSpend;
    double retirement;
    double postTax;
    double preDeductions;
    SharedPreferences sharedPreferences;
    public Deductions(){

    }
    public Deductions(int i){
        sharedPreferences = MainActivity.getContextOfApp().getSharedPreferences("com.example.spykexx.salarycalculator", Context.MODE_PRIVATE);
        setMedIns();
        setLifeIns();
        setFlexSpend();
        setRetirement();
        setPostTax();
    }

    public double getMedIns() {
        return medIns;
    }

    public void setMedIns() {

        this.medIns = Double.longBitsToDouble(sharedPreferences.getLong("medical_insurance", 0));
    }

    public double getLifeIns() {
        return lifeIns;
    }

    public void setLifeIns() {
        this.lifeIns = Double.longBitsToDouble(sharedPreferences.getLong("life_insurance", 0));
    }

    public double getFlexSpend() {
        return flexSpend;
    }

    public void setFlexSpend() {
        this.flexSpend = Double.longBitsToDouble(sharedPreferences.getLong("flex_spending", 0));
    }

    public double getRetirement() {
        return retirement;
    }

    public void setRetirement() {
        this.retirement = Double.longBitsToDouble(sharedPreferences.getLong("retirement", 0));
    }

    public double getPostTax() {
        return postTax;
    }

    public void setPostTax() {
        this.postTax = Double.longBitsToDouble(sharedPreferences.getLong("post_tax", 0));
    }

    public Double getPreDeductions(){
        preDeductions = (getMedIns() + getLifeIns() + getFlexSpend() + getRetirement());
        return preDeductions;
    }
}
