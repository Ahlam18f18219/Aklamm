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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Datial_Drass extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Datial_Drass.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Datial_Drass.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Datial_Drass.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Datial_Drass.this, Navgationahlm.class));
        }
       else if (id== R.id.logoutt) {
            startActivity(new Intent(Datial_Drass.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    TextView detailname, detailDescription;
    ImageView detailIamge;

    Button Bookdr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datial_drass);

        detailname = findViewById(R.id.detailname);
        detailDescription = findViewById(R.id.detailDescription);
        detailIamge = findViewById(R.id.detailIamge);
        Bookdr = findViewById(R.id.Bookdr);


        Bookdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Datial_Drass.this, Booking_Hairdr.class);
                startActivity(intent);
            }
        });


        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            detailDescription.setText(bundle.getString("Description"));
            detailname.setText(bundle.getString("name"));
            Glide.with(this).load(bundle.getString("image")).into(detailIamge);
        }

    }
}
