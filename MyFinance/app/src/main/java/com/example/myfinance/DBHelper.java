package com.example.myfinance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "accountsDB";
    private static final String TABLE_NAME_CDS = "cds";
    private static final String TABLE_NAME_LOANS = "loan";
    private static final String TABLE_NAME_CHECKING = "checking";
    private static final int DB_VERSION = 1;
    private static final String ID_COL = "id";
    private static final String ACCOUNT_NUM_COL = "accountNumber";
    private static final String INITIAL_BAL_COL = "initialBalance";
    private static final String CURRENT_BAL_COL = "currentBalance";
    private static final String INTEREST_RATE_COL = "interestRate";
    private static final String PAYMENT_AMT_COL = "paymentAmount";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create CDS Table
        String query = "CREATE TABLE " + TABLE_NAME_CDS + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ACCOUNT_NUM_COL + " TEXT," + INITIAL_BAL_COL + " TEXT," + CURRENT_BAL_COL + " TEXT," + INTEREST_RATE_COL + " TEXT)";
        db.execSQL(query);

        // Create Loans Table
        String query1 = "CREATE TABLE " + TABLE_NAME_LOANS + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ACCOUNT_NUM_COL + " TEXT," + INITIAL_BAL_COL + " TEXT," + CURRENT_BAL_COL + " TEXT," + PAYMENT_AMT_COL + " TEXT," + INTEREST_RATE_COL + " TEXT)";
        db.execSQL(query1);

        // Create CHECKING table
        String query2 = "CREATE TABLE " + TABLE_NAME_CHECKING + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ACCOUNT_NUM_COL + " TEXT," + CURRENT_BAL_COL + " TEXT)";
        db.execSQL(query2);

    }

    public void saveDetailsCDS(String accountNumber, String initialBalance, String currentBalance, String interestRate) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ACCOUNT_NUM_COL, accountNumber);
        values.put(INITIAL_BAL_COL, initialBalance);
        values.put(CURRENT_BAL_COL, currentBalance);
        values.put(INTEREST_RATE_COL, interestRate);

        db.insert(TABLE_NAME_CDS, null, values);
        db.close();

    }

    public void saveDetailsChecking(String accountNumber, String currentBalance) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ACCOUNT_NUM_COL, accountNumber);
        values.put(CURRENT_BAL_COL, currentBalance);

        db.insert(TABLE_NAME_CHECKING, null, values);
        db.close();
    }

    public void saveDetailsLoans(String accountNumber, String initialBalance, String currentBalance, String paymentAmount, String interestRate) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ACCOUNT_NUM_COL, accountNumber);
        values.put(INITIAL_BAL_COL, initialBalance);
        values.put(CURRENT_BAL_COL, currentBalance);
        values.put(PAYMENT_AMT_COL, paymentAmount);
        values.put(INTEREST_RATE_COL, interestRate);

        db.insert(TABLE_NAME_LOANS, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Check if CDS Exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LOANS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CHECKING);
        onCreate(db);
    }
}
