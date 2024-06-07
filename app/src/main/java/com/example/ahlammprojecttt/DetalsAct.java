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

public class DetalsAct extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(DetalsAct.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(DetalsAct.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(DetalsAct.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(DetalsAct.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(DetalsAct.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    TextView detailname, detailDescription;
    ImageView detailIamge;

    Button Bookidn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detals);

        detailname = findViewById(R.id.detailname);
        detailDescription = findViewById(R.id.detailDescription);
        detailIamge = findViewById(R.id.detailIamge);
        Bookidn = findViewById(R.id.Bookidn);

        initial();
    }

    private void initial() {

        Bookidn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(DetalsAct.this, Booking_HairCut.class);
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