package com.example.fitnezzgekzzp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DaysOp extends AppCompatActivity {

    private Spinner weekdaysSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_op);

        // Get a reference to the spinner widget
        weekdaysSpinner = findViewById(R.id.weekdays_spinner);

        // Set up the spinner's OnItemSelectedListener
        weekdaysSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Monday")) {
                    Intent intent = new Intent(DaysOp.this, monday.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Tuesday")) {
                    Intent intent = new Intent(DaysOp.this, tuesday.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Wednesday")) {
                    Intent intent = new Intent(DaysOp.this, wednesday.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Thursday")){
                    Intent intent = new Intent(DaysOp.this,thursday.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Friday")){
                    Intent intent = new Intent(DaysOp.this,Friday.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Saturday")){
                    Intent intent = new Intent(DaysOp.this,saturday.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }}
