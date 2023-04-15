package com.example.fitnezzgekzzp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Profile extends AppCompatActivity {

    private TextView mNameText;
    private TextView mEmailText;
    private TextView mMobileText;
    private ImageView mProfileImage;

    private FirebaseAuth mAuth;
    private DatabaseReference mUsersRef;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Firebase components
        mAuth = FirebaseAuth.getInstance();
        mUsersRef = FirebaseDatabase.getInstance().getReference("users");

        // Initialize UI components
        mNameText = findViewById(R.id.name_text);
        mEmailText = findViewById(R.id.email_text);
        mMobileText = findViewById(R.id.mobile_text);
        mProfileImage = findViewById(R.id.profile_image);
        mProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        // Get the current user's UID
        String uid = mAuth.getCurrentUser().getUid();

        // Retrieve the user's information from the database
        mUsersRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Get the User object
                User user = snapshot.getValue(User.class);

                // Display the user's information in the UI
                mNameText.setText(user.getName());
                mEmailText.setText(user.getEmail());
                mMobileText.setText(user.getMobile());

                // Display the user's profile picture in the UI using Picasso
                if (user.getImageUrl() != null) {
                    Picasso.get().load(user.getImageUrl()).into(mProfileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }

    // Allow the user to choose an image from their device
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // After the user selects a new profile picture, set the ImageView to display the new picture
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mImageUri);
                mProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
