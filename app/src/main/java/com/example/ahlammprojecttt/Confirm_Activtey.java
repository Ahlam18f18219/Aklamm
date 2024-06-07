package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirm_Activtey extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Confirm_Activtey.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Confirm_Activtey.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Confirm_Activtey.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Confirm_Activtey.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(Confirm_Activtey.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    TextView confirmName, confirmPhone, confirmDate, confirmServices;
    Button Confirr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_activtey);

        confirmName = findViewById(R.id.confirmName);
        confirmPhone = findViewById(R.id.confirmPhone);
        confirmDate = findViewById(R.id.confirmDate);
        confirmServices = findViewById(R.id.confirmServices);
        Confirr = findViewById(R.id.Confirr);

        initial();

    }

    private void initial(){
        Confirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Confirm_Activtey.this, Thanks_Activty.class);
                startActivity(intent);
            }
        });

        shoeConfirm();
    }

    public void shoeConfirm(){
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String Date = intent.getStringExtra("Date");
        String servies = intent.getStringExtra("servies");


        confirmName.setText(name);
        confirmPhone.setText(phone);
        confirmDate.setText(Date);
        confirmServices.setText(servies);

    }
}