package com.example.calculatevat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText price;
    Button calculate;
    TextView totalprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = findViewById(R.id.price);
        calculate = findViewById(R.id.calculate);
        totalprice = findViewById(R.id.totalprice);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(String.valueOf(price.getText()));
                    calculator();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You have exceeded the Input limit!", Toast.LENGTH_LONG).show();
                    price.setText("");
                }
            }
        });
    }


    @SuppressLint("SetTextI18n")
    public void calculator ()
    {
        double Total = 0;
        double VAT = 0;
        double in;
        in = Double.parseDouble(price.getText().toString());


        VAT = (in * 8) / 100;
        Total = in + VAT;

        totalprice.setText("Price: " + in + " TL" + "\n \n" +"VAT: " + VAT + " TL" + "\n \n" + "Total Price: " + Total + " TL");
    }
}
