package com.example.myfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CdsActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cds);
        dbHelper = new DBHelper(this);
        findViewById(R.id.cdsCancelButton).setOnClickListener(this::onCancel);

        findViewById(R.id.cdsSaveButton).setOnClickListener(this::onSave);

    }

    private void onCancel(View view) {
        this.finish();
        super.onBackPressed();
    }

    private void onSave(View view) {
        // Save data to the DB
        EditText accountInfo = findViewById(R.id.cdsAccountNumberField);
        EditText initialInfo = findViewById(R.id.cdsInitialBalanceField);
        EditText currentInfo = findViewById(R.id.cdsCurrentBalanceField);
        EditText interestInfo = findViewById(R.id.cdsInterestRateField);
        String accountNumber = accountInfo.getText().toString().equals("") ? "0" : accountInfo.getText().toString();
        String initialAmount = initialInfo.getText().toString().equals("") ? "0" : initialInfo.getText().toString();
        String currentAmount = currentInfo.getText().toString().equals("") ? "0" : currentInfo.getText().toString();
        String interestAmount = interestInfo.getText().toString().equals("") ? "0" : interestInfo.getText().toString();

        dbHelper.saveDetailsCDS(accountNumber, initialAmount, currentAmount, interestAmount);
        // Show success message
        Toast.makeText(CdsActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

}