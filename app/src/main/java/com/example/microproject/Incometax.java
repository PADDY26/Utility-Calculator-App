package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Incometax extends AppCompatActivity {

    Button b1;
    EditText e1;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incometax);

        b1=findViewById(R.id.button2);
        e1=findViewById(R.id.income);
        t1=findViewById(R.id.tax);
        t2=findViewById(R.id.totalamount);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= e1.getText().toString();

                if (str1.matches("")) {
                    Toast.makeText(getApplicationContext(),"ENTER YOUR INCOME",Toast.LENGTH_LONG).show();
                    e1.requestFocus();
                    return;
                }
                else {
                    calculate();
                }


            }
        });
    }

    public void calculate()
    {
        long Total = 0;
        long Tax= 0;
        long in= Integer.parseInt(e1.getText().toString());


        if(in<250000)
        {
            Toast.makeText(getApplicationContext(),"NO TAX FOR YOU :)",Toast.LENGTH_LONG).show();
        }
        else {

            if (in >= 250000 && in < 500000)
            {
                Tax= (in * 5)/100;
                Total = in + Tax;
            }
            else if(in >= 500000 && in < 750000)
            {
                Tax = (in * 10)/100;
                Total = in + Tax;
            }
            else if(in >= 750000 && in < 1000000)
            {
                Tax= (in * 15)/100;
                Total = in + Tax;
            }
            else if (in >= 1000000 && in < 1250000)
            {
                Tax = (in * 20)/100;
                Total = in + Tax;
            }
            else if(in >= 1250000 && in < 1500000)
            {
                Tax = (in * 25)/100;
                Total = in + Tax;
            }
            else if (in >= 1500000)
            {
                Tax = (in * 30)/100;
                Total = in + Tax;
            }

            t1.setText("₹ "+Tax);
            t2.setText("₹ "+Total);
        }


    }
}