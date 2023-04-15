package com.example.fitnezzgekzzp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    EditText Name;
    EditText Mobile;
    EditText Gender;
    EditText mail;
    EditText Password;
    EditText ConfirmPassword;
    Button Register;
    FirebaseAuth mAuth;
    String Email;
    String password;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        Name = (EditText) findViewById(R.id.Name);
        Mobile = (EditText) findViewById(R.id.Mb);
        mail = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.pwd);
        ConfirmPassword = (EditText) findViewById(R.id.cpwd);
        Register = (Button) findViewById(R.id.rgtn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString().trim();
                String mobile = Mobile.getText().toString().trim();
                String email = mail.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String confirmPassword = ConfirmPassword.getText().toString().trim();



                // Validate fields
                if (name.isEmpty()) {
                    Name.setError("Enter your name");
                    return;
                }

                if (mobile.isEmpty() || mobile.length() != 10) {
                    Mobile.setError("Enter valid mobile number");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mail.setError("Enter valid email!");
                    return;
                }

                if (password.isEmpty() || password.length() < 8) {
                    Password.setError("Password must be at least 8 characters long");
                    return;
                }

                if (!confirmPassword.equals(password)) {
                    ConfirmPassword.setError("Passwords don't match");
                    return;
                }

                DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    // Create a new user object
                                    User newUser = new User(name, mobile, email, imageUrl);

                                    // Save the user object to the database
                                    usersRef.child(user.getUid()).setValue(newUser);

                                    // redirect user to login activity
                                    Intent intent = new Intent(Registration.this, Login.class);
                                    startActivity(intent);
                                    finish(); // Add this line to finish the current activity and prevent user from going back to it using back button
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });


    }}
