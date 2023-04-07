package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeightGain extends AppCompatActivity {

    Button diet;
    Button workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);
        workout=findViewById(R.id.workout);
        diet=findViewById(R.id.diet);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(WeightGain.this,DaysOp.class);
                startActivity(intent);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightGain.this,dietwl.class);
                startActivity(intent);
            }
        });
    }
}