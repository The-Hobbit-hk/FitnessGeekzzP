package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class Options extends AppCompatActivity {

    Button btnbmi, btnloss, btngain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnbmi = (Button) findViewById(R.id.btnbmi);
        btnloss = (Button) findViewById(R.id.btnloss);
        btngain = (Button) findViewById(R.id.btngain);

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