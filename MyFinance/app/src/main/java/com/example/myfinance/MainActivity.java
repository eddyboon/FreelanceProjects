package com.example.myfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSelect(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        if (radioButton.getText().toString().equals("CDs")) {
            // To go to CDs page
            Intent openCds = new Intent(MainActivity.this, CdsActivity.class);
            startActivity(openCds);
        } else if (radioButton.getText().toString().equals("Loans")) {
            // To go to Loans page
            Intent openLoans = new Intent(MainActivity.this, LoansActivity.class);
            startActivity(openLoans);
        } else if (radioButton.getText().toString().equals("Checking")) {
            Intent openChecking = new Intent(MainActivity.this, CheckingActivity.class);
            startActivity(openChecking);
        }





    }


}