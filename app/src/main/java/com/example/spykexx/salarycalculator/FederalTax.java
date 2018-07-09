package com.example.spykexx.salarycalculator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Spykexx on 6/10/2018.
 */

public class FederalTax {
    SharedPreferences sharedPreferences;
    double taxRate;
    public FederalTax(){}
    public FederalTax(double grossPay){
        sharedPreferences = MainActivity.getContextOfApp().getSharedPreferences("com.example.spykexx.salarycalculator", Context.MODE_PRIVATE);

        setTaxRate(fedTaxCalc(grossPay));
    }
    public double getTaxRate(){
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    private double fedTaxCalc(double grossPay){
        double Tax = 0;
        boolean m = false;
        m = sharedPreferences.getBoolean("married", false);
        if (m == false) {
            if (grossPay < 142) {
                Tax = 0;
            } else if (grossPay >= 142 && grossPay <= 508.99) {
                Tax = ((grossPay - 142) * .1);
            } else if (grossPay >= 509 && grossPay <= 1630.99) {
                Tax = ((grossPay - 509) * .12) + 36.70;
            } else if (grossPay >= 1631 && grossPay <= 3314.99) {
                Tax = ((grossPay - 1631) * .22) + 171.34;
            } else if (grossPay >= 3315 && grossPay <= 6199.99) {
                Tax = ((grossPay - 3315) * .24) + 541.82;
            } else if (grossPay >= 6200 && grossPay <= 7834.99) {
                Tax = ((grossPay - 6200) * .32) + 1234.22;
            } else if (grossPay >= 7835 && grossPay <= 19372.99) {
                Tax = ((grossPay - 7835) * .35) + 1757.42;
            } else if (grossPay >= 19373) {
                Tax = ((grossPay - 19373) * .37) + 5795.72;
            }

        }
        else if (m == true){
            if (grossPay < 444) {
                Tax = 0;
            } else if (grossPay >= 444 && grossPay <= 1176.99) {
                Tax = ((grossPay - 444) * .1);
            } else if (grossPay >= 1177 && grossPay <= 3420.99) {
                Tax = ((grossPay - 1177) * .12) + 73.30;
            } else if (grossPay >= 3421 && grossPay <= 6789.99) {
                Tax = ((grossPay - 3421) * .22) + 342.58;
            } else if (grossPay >= 6790 && grossPay <= 12559.99) {
                Tax = ((grossPay - 6790) * .24) + 1083.76;
            } else if (grossPay >= 12560 && grossPay <= 15828.99) {
                Tax = ((grossPay - 12560) * .32) + 2468.56;
            } else if (grossPay >= 15829 && grossPay <= 23520.99) {
                Tax = ((grossPay - 15829) * .35) + 3514.64;
            } else if (grossPay >= 23521) {
                Tax = ((grossPay - 23521) * .37) + 6206.84;
            }
        }
        return Tax;
    }

}
