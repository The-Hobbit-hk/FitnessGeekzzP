package com.example.fitnezzgekzzp;

import static android.text.TextUtils.isEmpty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    Button Login;
    TextView Register;
    FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth=FirebaseAuth.getInstance();



        email = findViewById(R.id.mail);
        password = findViewById(R.id.pswd);
        Login = findViewById(R.id.loginbtn);
        Register=findViewById(R.id.sgn);
        // Get the SharedPreferences instance
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

// Check if the "loggedIn" key exists and its value is true
        if (prefs.contains("loggedIn") && prefs.getBoolean("loggedIn", false)) {
            // User is already logged in, start MainActivity and finish LoginActivity
            Intent intent = new Intent(Login.this, Options.class);
            startActivity(intent);
            finish();
        }




        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Password = password.getText().toString();
                String Email = email.getText().toString();


                mAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(com.example.fitnezzgekzzp.Login.this,Options.class);
                                    startActivity(intent);

                                    FirebaseUser user = mAuth.getCurrentUser();

                                } else {

                                    Toast.makeText(Login.this, "Incorrect Email id or Password",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }

        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(com.example.fitnezzgekzzp.Login.this,Registration.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }}
