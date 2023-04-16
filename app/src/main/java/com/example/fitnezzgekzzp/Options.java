package com.example.fitnezzgekzzp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Options extends AppCompatActivity {

    Button btnbmi, btnloss, btngain;
    BottomNavigationView bottomNavigation1;

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        // Get references to UI elements
        btnbmi = (Button) findViewById(R.id.btnbmi);
        btnloss = (Button) findViewById(R.id.btnloss);
        btngain = (Button) findViewById(R.id.btngain);
        bottomNavigation1 = findViewById(R.id.bottom_nav);
        mVideoView = (VideoView) findViewById(R.id.videoView);

        // Set up the video view
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gym);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mVideoView.start();
                mediaPlayer.setLooping(true);
            }
        });

        // Set a listener for the bottom navigation bar
        bottomNavigation1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pro:
                        Intent intent= new Intent(Options.this, Profile.class);
                        startActivity(intent);
                        return true;
                    case R.id.set:
                        Intent intent1 = new Intent(Options.this, Settings.class);
                        startActivity(intent1);
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Set listeners for the three buttons
        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, BMI.class);
                startActivity(intent);
            }
        });

        btnloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, WeightGain.class);
                startActivity(intent);
            }
        });

        btngain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, WeightLoss.class);
                startActivity(intent);
            }
        });
    }
}
