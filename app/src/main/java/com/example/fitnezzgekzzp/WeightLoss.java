package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WeightLoss extends AppCompatActivity {

    ImageView home;
    Button diet;
    Button workout;
    ImageView logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);

        diet= findViewById(R.id.diet);
        workout=findViewById(R.id.workout);
        home=findViewById(R.id.home);
        logout=findViewById(R.id.logout1);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(WeightLoss.this,Login.class);
                startActivity(intent1);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightLoss.this,Options.class);
                startActivity(intent);
            }
        });

    }

}