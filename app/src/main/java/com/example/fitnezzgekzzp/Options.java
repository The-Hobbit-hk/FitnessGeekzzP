package com.example.fitnezzgekzzp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.Inet4Address;

public class Options extends AppCompatActivity {

    Button btnbmi, btnloss, btngain;
    BottomNavigationView bottomNavigation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnbmi = (Button) findViewById(R.id.btnbmi);
        btnloss = (Button) findViewById(R.id.btnloss);
        btngain = (Button) findViewById(R.id.btngain);
        bottomNavigation1=findViewById(R.id.bottom_nav);

        bottomNavigation1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return false;
            }
        });


        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,BMI.class);
                startActivity(intent);

            }

        });
        btnloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Options.this,WeightGain.class);
                startActivity(intent);
            }
        });
        btngain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,WeightLoss.class);
                startActivity(intent);
            }
        });

    }
}