package com.example.ahlammprojecttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminloginn extends AppCompatActivity {


    EditText admname, admpass;
    Button admlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminloginn);

        admname = findViewById(R.id.amiuser);
        admpass = findViewById(R.id.passwo);
        admlog = findViewById(R.id.adminlog);

        admlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (admname.getText().toString().equals("Ahlam") && admpass.getText().toString().equals("123456"))
                {
                    Toast.makeText(Adminloginn.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Adminloginn.this, Servies_Admin.class));
                } else {
                    Toast.makeText(Adminloginn.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}