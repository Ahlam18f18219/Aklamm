package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupUser extends AppCompatActivity {

    private FirebaseAuth auth;

    Button signup;
    EditText name, email, pass;
    TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        signup = (Button) findViewById(R.id.signup);
        name = (EditText) findViewById(R.id.usernamsi);
        email = (EditText) findViewById(R.id.Emaill);
        pass = (EditText) findViewById(R.id.passwosig);
        log = (TextView) findViewById(R.id.sinn);

        auth = FirebaseAuth.getInstance();
        initial();

    }

    private void initial() {

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SignupUser.this, LoginUser.class);
                startActivity(intent);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString().trim();
                String passw = pass.getText().toString().trim();

                if (user.isEmpty()) {
                    email.setError("Enter your email");
                }
                if (passw.isEmpty()) {
                    pass.setError("Enter your paswword");
                } else {
                    auth.createUserWithEmailAndPassword(user,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupUser.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignupUser.this,LoginUser.class));
                            }else {
                                Toast.makeText(SignupUser.this,"Singup Failed"+ task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}