// Trainer.java

package com.example.fitnezzgekzzp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends AppCompatActivity {
    private ListView listView;
    private TrainerAdapter adapter;
    private List<trainer1> trainers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        // Initialize trainers list
        trainers = new ArrayList<>();
        trainers.add(new trainer1("Disha Gupta", "Disha@gmail.com", R.drawable.pro, "8780142810"));
        trainers.add(new trainer1("Harshvardhan", "harsh@gmail.com", R.drawable.pro, "8390662266"));
        trainers.add(new trainer1("Pratik Kapse", "pratikkapse@gmail.com", R.drawable.pro, "8605467665"));
        trainers.add(new trainer1("Shivam Gupta", "shivamgupta@gmail.com", R.drawable.pro, "7083534048"));

        // Initialize ListView and TrainerAdapter
        listView = findViewById(R.id.listView1);
        adapter = new TrainerAdapter(this, R.layout.trainer_item, trainers);
        listView.setAdapter(adapter);

        // Set ListView item click listener to make a phone call
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trainer1 trainer = trainers.get(position);
                String phoneNumber = "tel:" + trainer.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
        });
    }
}
