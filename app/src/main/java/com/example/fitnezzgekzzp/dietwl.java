package com.example.fitnezzgekzzp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dietwl extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietwl);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.morning:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container, new morning())
                                        .commit();
                                return true;
                            case R.id.afternoon:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container, new afternoon())
                                        .commit();
                                return true;
                            case R.id.night:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container, new night())
                                        .commit();
                                return true;
                            default:
                                return false;
                        }

                    }
                });
    }
}