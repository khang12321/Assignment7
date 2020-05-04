package com.example.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int intTruckLength;
    float decMiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText truckLength = (EditText) findViewById(R.id.txtTruckLength);
        final EditText miles = (EditText)findViewById(R.id.txtMiles);

        Button button = (Button)findViewById(R.id.btnCompute);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intTruckLength = Integer.parseInt(truckLength.getText().toString());
                decMiles = Integer.parseInt(miles.getText().toString());


                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intTruckLength);
                editor.putFloat("key2", decMiles);
                editor.commit();

                startActivity(new Intent(MainActivity.this, TruckRental.class));
            }
        });
    }
}
