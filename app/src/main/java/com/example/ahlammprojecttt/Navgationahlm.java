package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Navgationahlm extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Navgationahlm.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Navgationahlm.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Navgationahlm.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Navgationahlm.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(Navgationahlm.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    CardView shopj, ahlmm , ahlamu, shop;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navgationahlm);

        shopj = findViewById(R.id.shopj);
        ahlmm = findViewById(R.id.ahlmm);
        ahlamu = findViewById(R.id.ahlamu);
        shop = findViewById(R.id.shop);

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navgationahlm.this, Servies_Activety.class);
                startActivity(intent);
            }
        });

        ahlamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navgationahlm.this, mancare_Activty.class);
                startActivity(intent);
            }
        });

        ahlmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navgationahlm.this, Hairdressing_Avtiv.class);
                startActivity(intent);
            }
        });


        shopj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navgationahlm.this, Washhair_Act.class);
                startActivity(intent);
            }
        });

    }
}