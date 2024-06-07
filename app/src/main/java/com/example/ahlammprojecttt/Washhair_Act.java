package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Washhair_Act extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Washhair_Act.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Washhair_Act.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Washhair_Act.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Washhair_Act.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(Washhair_Act.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    GridView gridViewhu;
    ArrayList<DataServies> dataList;
    Washad washad;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Wash hair");


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washhair);

        gridViewhu = findViewById(R.id.gridViewhu);
        dataList = new ArrayList<>();
        washad = new Washad(dataList, this);
        gridViewhu.setAdapter(washad);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    DataServies dataServies = dataSnapshot.getValue(DataServies.class);
                    dataList.add(dataServies);
                }
                washad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}