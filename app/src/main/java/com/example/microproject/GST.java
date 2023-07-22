package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GST extends AppCompatActivity {

    Button b1;
    EditText e1, e2;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst);

    b1=findViewById(R.id.button3);
    e1=findViewById(R.id.cost);
    e2=findViewById(R.id.percent);
    t1=findViewById(R.id.gst);
    t2=findViewById(R.id.totalamount);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String str1= e1.getText().toString();
            String str2= e2.getText().toString();

            if (str1.matches("")) {
                Toast.makeText(getApplicationContext(),"ENTER ORIGINAL COST",Toast.LENGTH_LONG).show();
                e1.requestFocus();
                return;
            }
            if (str2.matches("")) {
                Toast.makeText(getApplicationContext(),"ENTER PERCENTAGE OF AMOUNT",Toast.LENGTH_LONG).show();
                e2.requestFocus();
                return;
            }


            //CALCULATION..............................

            long cost= Integer.parseInt(str1);
            long gst= Integer.parseInt(str2);
            long calgst;
            long price;

            //GST Amount = (Original Cost x GST%)/100

            calgst=((cost*gst)/100);
            price=calgst+cost;

            t1.setText("₹"+String.valueOf(calgst));
            t2.setText("₹"+String.valueOf(price));

        }
    });

}
}