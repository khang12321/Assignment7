package com.example.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TruckRental extends AppCompatActivity {
    float truck10Cost = (float) 19.95;
    float truck17Cost = (float) 29.95;
    float truck26Cost = (float) 39.95;
    float aMileCost = (float) 0.99;
    float truckCost;
    float decCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_rental);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView totalCost = (TextView)findViewById(R.id.txtTotalCost);
        ImageView image = (ImageView)findViewById(R.id.imgTruck);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intTruckLength = sharedPref.getInt("key1", 0);
        float decMiles = sharedPref.getFloat("key2", 0);

        if (intTruckLength == 10) {
            image.setImageResource(R.drawable.truck10);
            truckCost = truck10Cost;
            displayTotalCost(truckCost,decMiles);
        }else if (intTruckLength == 17){
            image.setImageResource(R.drawable.truck17);
            truckCost = truck17Cost;
            displayTotalCost(truckCost,decMiles);
        }else if (intTruckLength == 26){
            image.setImageResource(R.drawable.truck26);
            truckCost = truck26Cost;
            displayTotalCost(truckCost,decMiles);
        }else {
            totalCost.setText("Enter Truck Length 10, 17, or 26-foot truck");
        }

    }
    // tc truck cost, m miles
    void displayTotalCost(float tc, float m){
        TextView totalCost = (TextView)findViewById(R.id.txtTotalCost);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        decCost = tc + m * aMileCost;
        totalCost.setText("Total cost of a day with the miles is " + currency.format(decCost));
    }
}
