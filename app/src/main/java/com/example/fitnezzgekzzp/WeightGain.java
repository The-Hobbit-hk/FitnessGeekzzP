package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class WeightGain extends AppCompatActivity {

    Button diet;
    Button workout;


    ImageView logout,home;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);
        workout=findViewById(R.id.workout);
        diet=findViewById(R.id.diet);
        logout=findViewById(R.id.logout1);
        home=findViewById(R.id.home);

        mauth = FirebaseAuth.getInstance();

        logout = findViewById(R.id.logout1);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mauth.signOut();
                Intent intent = new Intent(WeightGain.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
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
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightGain.this,Options.class);
                startActivity(intent);
            }
        });
    }
}