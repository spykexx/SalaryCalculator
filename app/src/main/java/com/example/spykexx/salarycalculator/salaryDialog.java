package com.example.spykexx.salarycalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;



/**
 * Created by Spykexx on 6/19/2016.
 */
public class salaryDialog extends DialogFragment implements View.OnClickListener {
    calcNew activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (calcNew) getActivity();
        //Double[] myData = activity.getMyData();
        DecimalFormat df = new DecimalFormat("0.00");
        View view = inflater.inflate(R.layout.salary_dialog, container, false);

        Button btnDismiss = (Button)view.findViewById(R.id.btnDismiss);
        TextView txtGrossPay = (TextView) view.findViewById(R.id.etGrossPay);
        TextView txtSubtotal = (TextView) view.findViewById(R.id.etSubtotal);
        TextView txtFedTax = (TextView) view.findViewById(R.id.etFedTax);
        TextView txtStateTax = (TextView) view.findViewById(R.id.etStateTax);
        TextView txtSS = (TextView) view.findViewById(R.id.etSS);
        TextView txtMedicare = (TextView) view.findViewById(R.id.etMedicare);
        TextView txtDeductions = (TextView) view.findViewById(R.id.etDeductions);
        TextView txtPostDeduct = (TextView) view.findViewById(R.id.etPostTax);
        TextView txtNetPay = (TextView) view.findViewById(R.id.etNetPay);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        txtGrossPay.setText("$" + df.format(activity.payStatement.getGrossPay()));
        txtSubtotal.setText("$" + df.format(activity.payStatement.getGrossPostPay()));
        txtFedTax.setText("$" + df.format(activity.payStatement.getFederalTaxes()));
        txtStateTax.setText("$" + df.format(activity.payStatement.getStateTaxes()));
        txtSS.setText("$" + df.format(activity.payStatement.getSocialSecurity()) );
        txtMedicare.setText("$" + df.format(activity.payStatement.getMedicare()));
        txtDeductions.setText("$" + df.format(activity.payStatement.getPreDeduction()) );
        txtPostDeduct.setText("$" + df.format(activity.payStatement.getPostDeduction()) );
        txtNetPay.setText("$" + df.format(activity.payStatement.getTotal()));
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;

    }


    @Override
    public void onClick(View view) {

    }

    public void onDismiss(DialogInterface.OnDismissListener onDismissListener) {

    }
}
