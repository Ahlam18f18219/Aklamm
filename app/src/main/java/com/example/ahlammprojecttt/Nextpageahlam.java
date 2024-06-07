package com.example.ahlammprojecttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Nextpageahlam extends AppCompatActivity {

    Button userr, Adminn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpageahlam);

        userr = findViewById(R.id.userr);
        Adminn = findViewById(R.id.Adminn);

        initial ();

    }
    private void initial() {

        userr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(Nextpageahlam.this,LoginUser.class);
                startActivity(intent);
            }
        });

        Adminn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(Nextpageahlam.this,Adminloginn.class);
                startActivity(intent);
            }
        });
    }
}