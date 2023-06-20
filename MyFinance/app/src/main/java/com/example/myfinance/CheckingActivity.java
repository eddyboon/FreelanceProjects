package com.example.myfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CheckingActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        dbHelper = new DBHelper(this);
        findViewById(R.id.checkingCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCancel(v);
            }
        });

        findViewById(R.id.checkingSaveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSave(v);
            }
        });
    }

    private void onCancel(View view) {
        finish();
        super.onBackPressed();
    }

    private void onSave(View view) {
        // Save data to the DB
        EditText accountInfo = findViewById(R.id.checkingAccountNumberField);
        EditText currentInfo = findViewById(R.id.checkingCurrentBalanceField);
        String accountNumber = accountInfo.getText().toString().equals("") ? "0" : accountInfo.getText().toString();
        String currentNumber = currentInfo.getText().toString().equals("") ? "0" : currentInfo.getText().toString();

        dbHelper.saveDetailsChecking(accountNumber, currentNumber);
        // Show success message
        Toast.makeText(CheckingActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}