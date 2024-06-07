package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassw extends AppCompatActivity {

    EditText emailahlam;
    Button sendd;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passw);

        emailahlam = findViewById(R.id.emailpasww);
        sendd = findViewById(R.id.seneddd);
        auth = FirebaseAuth.getInstance();


        sendd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email;
                Email = String.valueOf(emailahlam.getText());

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(ForgotPassw.this, "Enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPassw.this, "Check your email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPassw.this,LoginUser.class));
                            finish();;;
                        }else {
                            Toast.makeText(ForgotPassw.this, "The Email failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}