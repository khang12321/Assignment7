package com.example.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Interest extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView interest = (TextView)findViewById(R.id.txtInterest);
        ImageView image = (ImageView)findViewById(R.id.imgYears);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        float decMonthlyPayment = sharedPref.getFloat("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        float decLoan = sharedPref.getFloat("key3", 0);
        float decInterest = 0;

        decInterest = (decMonthlyPayment * (intYears * 12)) - decLoan;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        interest.setText("Total interest paid " + currency.format(decInterest));


        if (intYears == 10) {
            image.setImageResource(R.drawable.ten);
        }else if (intYears == 20){
            image.setImageResource(R.drawable.twenty);
        }else if (intYears == 30){
            image.setImageResource(R.drawable.thirty);
        }else {
            interest.setText("Enter 10, 20, or 30 years");
        }
    }
}
