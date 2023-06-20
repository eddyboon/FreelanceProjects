package com.example.myfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoansActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans);
        dbHelper = new DBHelper(this);
        findViewById(R.id.loansCancelButton).setOnClickListener(this::onCancel);

        findViewById(R.id.loansSaveButton).setOnClickListener(this::onSave);
    }

    private void onCancel(View view) {
        finish();
        super.onBackPressed();
    }

    private void onSave(View view) {
        // Save data to the DB
        EditText accountInfo = findViewById(R.id.loansAccountNumberField);
        EditText initialInfo = findViewById(R.id.loansInitialBalanceField);
        EditText currentInfo = findViewById(R.id.loansCurrentBalanceField);
        EditText paymentInfo = findViewById(R.id.loansPaymentAmountField);
        EditText interestInfo = findViewById(R.id.loansInterestRateField);

        String accountNumber = accountInfo.getText().toString().equals("") ? "0" : accountInfo.getText().toString();
        String initialBalance = initialInfo.getText().toString().equals("") ? "0" : initialInfo.getText().toString();
        String currentBalance = currentInfo.getText().toString().equals("") ? "0" : currentInfo.getText().toString();
        String paymentAmount = paymentInfo.getText().toString().equals("") ? "0" : paymentInfo.getText().toString();
        String interestRate = interestInfo.getText().toString().equals("") ? "0" : interestInfo.getText().toString();

        dbHelper.saveDetailsLoans(accountNumber, initialBalance, currentBalance, paymentAmount, interestRate);
        // Show success message
        Toast.makeText(LoansActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}