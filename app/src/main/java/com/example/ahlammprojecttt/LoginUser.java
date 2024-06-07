package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

import java.util.regex.Pattern;

public class LoginUser extends AppCompatActivity {

    TextView logi, forgot;
    FirebaseAuth auth;
    EditText emill, pass;
    Button login;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        auth = FirebaseAuth.getInstance();
        emill = findViewById(R.id.emaillo);
        pass = findViewById(R.id.passwo);
        login = findViewById(R.id.loginapp);
        logi = (TextView) findViewById(R.id.signupp);
        forgot = (TextView) findViewById(R.id.Forarg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email  = emill.getText().toString();
                String passw = pass.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!passw.isEmpty()) {

                        auth.signInWithEmailAndPassword(email,passw)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {

                                        Toast.makeText(LoginUser.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(LoginUser.this, Navgationahlm.class));
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginUser.this, "Login Fiailed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        pass.setError("Password cannot be empty");
                    }

                }else if (email.isEmpty()) {
                    emill.setError("Email cannot be empty");
                } else {
                    emill.setError("pleas enter your email");
                }
            }
        });


        initial();

    }

    private void initial() {

        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginUser.this, SignupUser.class);
                startActivity(intent);
                finish();
            }
        });


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginUser.this, ForgotPassw.class);
                startActivity(intent);
                finish();
            }
        });
    }
}