package com.example.fitnezzgekzzp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dietwg extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Morn fragmentOne;
    private Aftn fragmentTwo;
    private Eve fragmentThree;
    private Fragment activeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietwg);


        fragmentOne = new Morn();
        fragmentTwo = new Aftn();
        fragmentThree = new Eve();

        // set default fragment
        activeFragment = fragmentOne;
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentOne).commit();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        bottomNavigationView.setOnNavigationItemSelectedListener(this);
                        bottomNavigationView.setSelectedItemId(R.id.fragment_container);
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