package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class WeightLoss extends AppCompatActivity {

    ImageView home;
    Button diet;
    Button workout;
    ImageView logout;

    FirebaseAuth mauth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);

        diet= findViewById(R.id.diet);
        workout=findViewById(R.id.workout);
        home=findViewById(R.id.home);
        logout=findViewById(R.id.logout1);

        mauth = FirebaseAuth.getInstance();

        logout = findViewById(R.id.logout1);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mauth.signOut();
                Intent intent = new Intent(WeightLoss.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WeightLoss.this,DayOp.class);
                startActivity(intent);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WeightLoss.this,dietwg.class);
                startActivity(intent);
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