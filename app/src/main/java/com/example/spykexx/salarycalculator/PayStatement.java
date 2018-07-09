package com.example.spykexx.salarycalculator;

import android.util.Log;

/**
 * Created by Spykexx on 2/18/2018.
 */

public class PayStatement {
    double hours;
    double pay;
    double otHours;
    double otPay;
    double grossPay;
    double grossPostPay;
    double stateTaxes;
    double federalTaxes;
    double medicare;
    double socialSecurity;
    double preDeduction;
    double postDeduction;
    StateTax stateTax = new StateTax();
    FederalTax federalTax = new FederalTax();
    Deductions deductions = new Deductions();

    public PayStatement(){

    }

    public PayStatement(double regHours, double regPay, Deductions deduct){
        setHours(regHours);
        setPay(regPay);
        setPreDeduction(deduct);
        setGrossPay(regPay, regHours);
        setGrossPostPay(getGrossPay());
        setStateTaxes(getGrossPostPay());
        setFederalTaxes(getGrossPostPay());
        setMedicare(getGrossPostPay());
        setSocialSecurity(getGrossPostPay());
        setPostDeduction(deduct);
    }


    public PayStatement(double regHours, double regPay, double ovtHours, double ovtPay, Deductions deduct){
        setPay(regPay);
        setHours(regHours);
        setOtHours(ovtHours);
        setOtPay(ovtPay);
        setPreDeduction(deduct);
        setGrossPay(regPay, regHours, ovtPay, ovtHours);
        setGrossPostPay(getGrossPay());
        setStateTaxes(getGrossPostPay());
        setFederalTaxes(getGrossPostPay());
        setMedicare(getGrossPostPay());
        setSocialSecurity(getGrossPostPay());
        setPostDeduction(deduct);
    }

    public double getPreDeduction() {
        return preDeduction;
    }

    public void setPreDeduction(Deductions deduct) {

        this.preDeduction = deduct.getPreDeductions();
    }

    public double getPostDeduction() {
        return postDeduction;
    }

    public void setPostDeduction(Deductions deduct) {
        this.postDeduction = deduct.getPostTax();
    }

    public double getFederalTaxes() {
        return federalTaxes;
    }

    public void setFederalTaxes(double grossPay) {
        federalTax = new FederalTax(grossPay);
        this.federalTaxes = federalTax.getTaxRate();
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double regPay, double regHours){
        this.grossPay = ((regPay * regHours));
    }

    public void setGrossPay(double regPay, double regHours, double ovtPay, double ovtHours) {
        this.grossPay = ((regPay * regHours) + (ovtHours * ovtPay));
    }

    public double getGrossPostPay() {
        return grossPostPay;
    }

    public void setGrossPostPay(double grossPay) {
        this.grossPostPay = grossPay - getPreDeduction();
    }

    public double getStateTaxes() {
        return stateTaxes;
    }

    public void setStateTaxes(double grossPay) {

        stateTax = new StateTax(grossPay);
        this.stateTaxes = stateTax.getTaxRate();
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getOtPay() {
        return otPay;
    }

    public double getMedicare() {
        return medicare;
    }

    public void setMedicare(double grossPay) {
        this.medicare = (grossPay * .0145);
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double grossPay) {
        this.socialSecurity = (grossPay * .062);
    }

    public void setOtPay(double otPay) {
        this.otPay = otPay;
    }
    public double getTotal(){

        double total;
        total = (getGrossPostPay() - (getFederalTaxes() + getStateTaxes() + getSocialSecurity() + getMedicare() + getPostDeduction()));
        Log.i("State Taxes ", Double.toString(stateTaxes));
        Log.i("Federal Taxes ", Double.toString(federalTaxes));
        return total;
    }
    public void clearAll(){
        otHours = 0;
        otPay = 0;
        pay = 0;
        hours = 0;
    }

    @Override
    public String toString() {
        return "Total : " + getTotal();
    }
}
