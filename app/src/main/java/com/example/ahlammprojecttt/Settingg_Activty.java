package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Settingg_Activty extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Settingg_Activty.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Settingg_Activty.this, Navgationahlm.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Settingg_Activty.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Settingg_Activty.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(Settingg_Activty.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingg_activty);
    }
}