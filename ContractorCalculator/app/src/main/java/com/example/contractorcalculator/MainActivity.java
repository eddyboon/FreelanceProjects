package com.example.contractorcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public TextView subTotal, tax, totalAmount;
    public EditText laborAmount, materialAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculate(View view) {
        // Get amount
        laborAmount = findViewById(R.id.laborAmount);
        materialAmount = findViewById(R.id.materialAmount);
        // Checking amount
        double laborAmountValue = laborAmount.getText().toString().equals("") ? 0 : Double.parseDouble(laborAmount.getText().toString());
        double materialAmountValue = materialAmount.getText().toString().equals("") ? 0 : Double.parseDouble(materialAmount.getText().toString());

        // Calculations
        double mySubTotalAmount = laborAmountValue + materialAmountValue;
        double taxValue = mySubTotalAmount * 0.05;
        double totalValue = taxValue + mySubTotalAmount;

        // Displaying Calculations
        subTotal = findViewById(R.id.subtotalAmount);
        tax = findViewById(R.id.taxAmount);
        totalAmount = findViewById(R.id.totalAmount);
        subTotal.setText("$" + String.format("%.2f", mySubTotalAmount));
        tax.setText("$" + String.format("%.2f", taxValue));
        totalAmount.setText("$" + String.format("%.2f", totalValue));

    }
}