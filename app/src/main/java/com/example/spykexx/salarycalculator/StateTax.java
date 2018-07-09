package com.example.spykexx.salarycalculator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Spykexx on 6/3/2018.
 */

public class StateTax {
    double taxRate;
    SharedPreferences sharedPreferences;
    public StateTax(){
        setTaxRate(0);
    }
    public StateTax(double grossPay){
    sharedPreferences = MainActivity.getContextOfApp().getSharedPreferences("com.example.spykexx.salarycalculator", Context.MODE_PRIVATE);
    if(sharedPreferences.getString("state", "Iowa").matches("Iowa")){
        setTaxRate(stTaxCalc(grossPay));
    } else {
        setTaxRate(stTaxCalc(grossPay));
    }
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public String toString() {
        return "StateTax{" +
                "taxRate=" + taxRate +
                '}';
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    private double stTaxCalc(double grossPay){
        double Tax = 0;
        if(sharedPreferences.getString("state", "Iowa").matches("Iowa")) {

            if (grossPay <= 159) {
                Tax = 0;
            } else if (grossPay >= 160 && grossPay <= 199.99) {
                Tax = 1;
            } else if (grossPay >= 200 && grossPay <= 239.99) {
                Tax = 2;
            } else if (grossPay >= 240 && grossPay <= 279.99) {
                Tax = 3;
            } else if (grossPay >= 280 && grossPay <= 299.99) {
                Tax = 4;
            } else if (grossPay >= 300 && grossPay <= 319.99) {
                Tax = 5;
            } else if (grossPay >= 320 && grossPay <= 339.99) {
                Tax = 6;
            } else if (grossPay >= 340 && grossPay <= 359.99) {
                Tax = 7;
            } else if (grossPay >= 360 && grossPay <= 389.99) {
                Tax = 8;
            } else if (grossPay >= 390 && grossPay <= 409.99) {
                Tax = 9;
            } else if (grossPay >= 410 && grossPay <= 429.99) {
                Tax = 10;
            } else if (grossPay >= 430 && grossPay <= 459.99) {
                Tax = 11;
            } else if (grossPay >= 460 && grossPay <= 489.99) {
                Tax = 12;
            } else if (grossPay >= 490 && grossPay <= 509.99) {
                Tax = 13;
            } else if (grossPay >= 510 && grossPay <= 539.99) {
                Tax = 14;
            } else if (grossPay >= 540 && grossPay <= 559.99) {
                Tax = 15;
            } else if (grossPay >= 560 && grossPay <= 569.99) {
                Tax = 16;
            } else if (grossPay >= 570 && grossPay <= 589.99) {
                Tax = 17;
            } else if (grossPay >= 590 && grossPay <= 609.99) {
                Tax = 18;
            } else if (grossPay >= 610 && grossPay <= 629.99) {
                Tax = 19;
            } else if (grossPay >= 630 && grossPay <= 649.99) {
                Tax = 20;
            } else if (grossPay >= 650 && grossPay <= 669.99) {
                Tax = 21;
            } else if (grossPay >= 670 && grossPay <= 689.99) {
                Tax = 22;
            } else if (grossPay >= 690 && grossPay <= 709.99) {
                Tax = 23;
            } else if (grossPay >= 710 && grossPay <= 729.99) {
                Tax = 24;
            } else if (grossPay >= 730 && grossPay <= 749.99) {
                Tax = 25;
            } else if (grossPay >= 750 && grossPay <= 769.99) {
                Tax = 26;
            } else if (grossPay >= 770 && grossPay <= 789.99) {
                Tax = 27;
            } else if (grossPay >= 790 && grossPay <= 809.99) {
                Tax = 28;
            } else if (grossPay >= 810 && grossPay <= 819.99) {
                Tax = 29;
            } else if (grossPay >= 820 && grossPay <= 839.99) {
                Tax = 30;
            } else if (grossPay >= 840 && grossPay <= 859.99) {
                Tax = 31;
            } else if (grossPay >= 860 && grossPay <= 879.99) {
                Tax = 32;
            } else if (grossPay >= 880 && grossPay <= 899.99) {
                Tax = 33;
            } else if (grossPay >= 900 && grossPay <= 919.99) {
                Tax = 34;
            } else if (grossPay >= 920 && grossPay <= 939.99) {
                Tax = 35;
            } else if (grossPay >= 940 && grossPay <= 959.99) {
                Tax = 36;
            } else if (grossPay >= 960 && grossPay <= 969.99) {
                Tax = 37;
            } else if (grossPay >= 970 && grossPay <= 989.99) {
                Tax = 38;
            } else if (grossPay >= 990 && grossPay <= 1009.99) {
                Tax = 39;
            } else if (grossPay >= 1010 && grossPay <= 1029.99) {
                Tax = 40;
            } else if (grossPay >= 1030 && grossPay <= 1049.99) {
                Tax = 41;
            } else if (grossPay >= 1050 && grossPay <= 1059.99) {
                Tax = 42;
            } else if (grossPay >= 1060 && grossPay <= 1079.99) {
                Tax = 43;
            } else if (grossPay >= 1080 && grossPay <= 1099.99) {
                Tax = 44;
            } else if (grossPay >= 1100 && grossPay <= 1119.99) {
                Tax = 45;
            } else if (grossPay >= 1120 && grossPay <= 1139.99) {
                Tax = 46;
            } else if (grossPay >= 1140 && grossPay <= 1149.99) {
                Tax = 47;
            } else if (grossPay >= 1150 && grossPay <= 1169.99) {
                Tax = 48;
            } else if (grossPay >= 1170 && grossPay <= 1189.99) {
                Tax = 49;
            } else if (grossPay >= 1190 && grossPay <= 1219.99) {
                Tax = 50;
            } else if (grossPay >= 1220 && grossPay <= 1239.99) {
                Tax = 51;
            } else if (grossPay >= 1240 && grossPay <= 1259.99) {
                Tax = 53;
            } else if (grossPay >= 1260 && grossPay <= 1279.99) {
                Tax = 54;
            } else if (grossPay >= 1280 && grossPay <= 1299.99) {
                Tax = 55;
            } else if (grossPay >= 1300 && grossPay <= 1319.99) {
                Tax = 56;
            } else if (grossPay >= 1320 && grossPay <= 1339.99) {
                Tax = 57;
            } else if (grossPay >= 1340 && grossPay <= 1359.99) {
                Tax = 58;
            } else if (grossPay >= 1360 && grossPay <= 1379.99) {
                Tax = 60;
            } else if (grossPay >= 1380 && grossPay <= 1399.99) {
                Tax = 61;
            } else if (grossPay >= 1400 && grossPay <= 1419.99) {
                Tax = 62;
            } else if (grossPay >= 1420 && grossPay <= 1439.99) {
                Tax = 63;
            } else if (grossPay >= 1440 && grossPay <= 1459.99) {
                Tax = 64;
            } else if (grossPay >= 1460 && grossPay <= 1479.99) {
                Tax = 65;
            } else if (grossPay >= 1480 && grossPay <= 1499.99) {
                Tax = 67;
            } else if (grossPay >= 1500 && grossPay <= 1519.99) {
                Tax = 68;
            } else if (grossPay >= 1520 && grossPay <= 1539.99) {
                Tax = 69;
            } else if (grossPay >= 1540 && grossPay <= 1559.99) {
                Tax = 70;
            } else if (grossPay >= 1560 && grossPay <= 1579.99) {
                Tax = 71;
            } else if (grossPay >= 1580 && grossPay <= 1599.99) {
                Tax = 72;
            } else if (grossPay >= 1600 && grossPay <= 1619.99) {
                Tax = 73;
            } else if (grossPay >= 1620 && grossPay <= 1639.99) {
                Tax = 74;
            } else if (grossPay >= 1640 && grossPay <= 1659.99) {
                Tax = 75;
            } else if (grossPay >= 1660 && grossPay <= 1679.99) {
                Tax = 76;
            } else if (grossPay >= 1680 && grossPay <= 1699.99) {
                Tax = 77;
            } else if (grossPay >= 1700 && grossPay <= 1719.99) {
                Tax = 78;
            } else if (grossPay >= 1720 && grossPay <= 1739.99) {
                Tax = 79;
            } else if (grossPay >= 1740 && grossPay <= 1759.99) {
                Tax = 80;
            } else if (grossPay >= 1760 && grossPay <= 1779.99) {
                Tax = 81;
            } else if (grossPay >= 1780 && grossPay <= 1799.99) {
                Tax = 82;
            } else if (grossPay >= 1800 && grossPay <= 1819.99) {
                Tax = 84;
            } else if (grossPay >= 1820 && grossPay <= 1839.99) {
                Tax = 85;
            } else if (grossPay >= 1840 && grossPay <= 1859.99) {
                Tax = 86;
            } else if (grossPay >= 1860 && grossPay <= 1879.99) {
                Tax = 87;
            } else if (grossPay >= 1880 && grossPay <= 1899.99) {
                Tax = 88;
            } else if (grossPay >= 1900 && grossPay <= 1919.99) {
                Tax = 90;
            } else if (grossPay >= 1920 && grossPay <= 1939.99) {
                Tax = 91;
            } else if (grossPay >= 1940 && grossPay <= 1959.99) {
                Tax = 92;
            } else if (grossPay >= 1960 && grossPay <= 1979.99) {
                Tax = 93;
            } else if (grossPay >= 1980 && grossPay <= 1999.99) {
                Tax = 94;
            } else if (grossPay >= 2000 && grossPay <= 2019.99) {
                Tax = 95;
            } else if (grossPay >= 2020 && grossPay <= 2039.99) {
                Tax = 97;
            } else if (grossPay >= 2040 && grossPay <= 2059.99) {
                Tax = 98;
            } else if (grossPay >= 2060 && grossPay <= 2079.99) {
                Tax = 99;
            } else if (grossPay >= 2080 && grossPay <= 2099.99) {
                Tax = 100;
            } else if (grossPay >= 2100 && grossPay <= 2119.99) {
                Tax = 101;
            } else if (grossPay >= 2120 && grossPay <= 2139.99) {
                Tax = 103;
            } else if (grossPay >= 2140 && grossPay <= 2159.99) {
                Tax = 104;
            } else if (grossPay >= 2160 && grossPay <= 2179.99) {
                Tax = 105;
            } else if (grossPay >= 2180 && grossPay <= 2199.99) {
                Tax = 106;
            } else if (grossPay >= 2200 && grossPay <= 2219.99) {
                Tax = 107;
            } else if (grossPay >= 2220 && grossPay <= 2239.99) {
                Tax = 109;
            } else if (grossPay >= 2240 && grossPay <= 2259.99) {
                Tax = 110;
            } else if (grossPay >= 2260 && grossPay <= 2279.99) {
                Tax = 111;
            } else if (grossPay >= 2280 && grossPay <= 2300) {
                Tax = 112;
            } else if (grossPay > 2300) {

                Tax = ((grossPay - 2300) * .0898) + 112;
            }
        } else if (sharedPreferences.getString("state", "Iowa").matches("Illinois")){
            Tax = (grossPay * 0.0495);
        }













        return Tax;
    }
}
