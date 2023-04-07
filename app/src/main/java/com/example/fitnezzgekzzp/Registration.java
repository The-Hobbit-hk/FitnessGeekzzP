package com.example.fitnezzgekzzp;



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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth=FirebaseAuth.getInstance();
        Name = (EditText) findViewById(R.id.Name);
        Mobile = (EditText) findViewById(R.id.Mb);
        mail = (EditText) findViewById(R.id.email);
        Password= (EditText) findViewById(R.id.pwd);
        ConfirmPassword= (EditText) findViewById(R.id.cpwd);
        Register= (Button) findViewById(R.id.rgtn);
        


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = Password.getText().toString();
                String email = mail.getText().toString();

                checkDataEntered();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(Registration.this, Login.class);
                                    startActivity(intent);
                                    FirebaseUser user = mAuth.getCurrentUser();

                                } else {


                                    Toast.makeText(Registration.this, "User Already Registered",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Add text watcher for confirm password EditText
        ConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateConfirmPassword();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }



    // Validation methods
    private void validatePassword() {
        String password = Password.getText().toString().trim();
        if (password.isEmpty()) {
           // Password.setError(getString(R.string.password_empty_error));
        } else if (password.length() < 8) {
          //  Password.setError(getString(R.string.password_length_error));
        } else {
            Password.setError(null);
        }
    }

    private void validateConfirmPassword() {
        String password = Password.getText().toString().trim();
        String confirmPassword = ConfirmPassword.getText().toString().trim();
        if (!confirmPassword.equals(password)) {
           // ConfirmPassword.setError(getString(R.string.confirm_password_error));
        } else {
            ConfirmPassword.setError(null);
        }
    }


    boolean isemail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(Name)) {
            Name.setError("Enter you name");
        }

        if (isEmpty(Mobile)) {
            Mobile.setError("Mobile is required!");
        }

        if (isemail(mail) == false) {
            mail.setError("Enter valid email!");
        }

        if (isEmpty(Password)) {
            Password.setError("Enter your password.");
        }
        if (isEmpty(ConfirmPassword)) {
            ConfirmPassword.setError("Enter your password.");
        }



    }
}
