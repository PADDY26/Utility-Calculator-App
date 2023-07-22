package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Principal;

public class Emi extends AppCompatActivity {

    Button b1;
    EditText loan, rate, years;
    TextView Emi, totalinterest,totalamnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        //BUTTONS
        b1=findViewById(R.id.button1);
        //EDITTEXT
        loan=findViewById(R.id.loanamount);
        rate=findViewById(R.id.rate);
        years=findViewById(R.id.tenure);
        //TEXTVIEWS
        Emi=findViewById(R.id.emi);
        totalinterest=findViewById(R.id.totalinterest);
        totalamnt=findViewById(R.id.totalamount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= loan.getText().toString();
                String str2= rate.getText().toString();
                String str3= years.getText().toString();

                if (str1.matches("")) {
                   Toast.makeText(getApplicationContext(),"ENTER LOAN AMOUNT",Toast.LENGTH_LONG).show();
                   loan.requestFocus();
                   return;
                }

                if (str2.matches("")) {
                    Toast.makeText(getApplicationContext(),"ENTER RATE OF INTEREST",Toast.LENGTH_LONG).show();
                    rate.requestFocus();
                    return;
                }

                if (str3.matches("")) {
                    Toast.makeText(getApplicationContext(),"ENTER YEARS",Toast.LENGTH_LONG).show();
                    years.requestFocus();
                    return;
                }


                double p = Double.parseDouble(str1);
                double i = Double.parseDouble(str2);
                double y = Double.parseDouble(str3);

                double Principal = calPric(p);

                double Rate = calInt(i);

                double Months = calMonth(y);

                double Divident = calDivident( Rate, Months);

                double FD = calFinalDivident(Principal, Rate, Divident);

                double D = calDivider(Divident);

                //EMI PER MONTH
                double emi = calEmi(FD, D);

                double TA = calTa (emi, Months);

                //TOTAL INTEREST
                double ti = calTotalInt(TA, Principal);

                //TOTAL AMOUNT PAYABLE
                double tamnt = calTotalamt(Principal,ti);

                Emi.setText("₹ "+String.valueOf(emi));

                totalinterest.setText("₹ "+String.valueOf(ti));

                totalamnt.setText("₹ "+String.valueOf(tamnt));
            }
        });
    }

    public  double calPric(double p) {

        return (p);

    }

    public  double calInt(double i) {

        return (i/12/100);

    }

    public  double calMonth(double y) {

        return (y * 12);

    }

    public  double calDivident(double Rate, double Months) {

        return Math.pow(1+Rate, Months);

    }

    public  double calFinalDivident(double Principal, double Rate, double divident) {

        return (Principal * Rate * divident);

    }

    public  double calDivider(double divident) {

        return (divident-1);

    }

    public  double calEmi(double FD, double D) {

        return (FD/D);

    }

    public  double calTa(double emi, double Months) {

        return (emi*Months);

    }

    public  double calTotalInt(double TA, double Principal) {

        return (TA - Principal);

    }

    public double calTotalamt(double Principal, double ti){
        return (Principal + ti);
    }
}