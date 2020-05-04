package com.example.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float decMonthlyPayment;
    int intYears;
    float decLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText monthlyPayment = (EditText) findViewById(R.id.txtMonthlyPayment);
        final EditText years = (EditText)findViewById(R.id.txtYears);
        final EditText loan = (EditText)findViewById(R.id.txtLoan);

        Button button = (Button)findViewById(R.id.btnCompute);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decMonthlyPayment = Float.parseFloat(monthlyPayment.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                decLoan = Float.parseFloat(loan.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decMonthlyPayment);
                editor.putInt("key2", intYears);
                editor.putFloat("key3", decLoan);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Interest.class));
            }
        });
    }
}
