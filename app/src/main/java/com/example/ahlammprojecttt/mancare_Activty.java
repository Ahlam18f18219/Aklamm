package com.example.ahlammprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class mancare_Activty extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(mancare_Activty.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(mancare_Activty.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(mancare_Activty.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(mancare_Activty.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(mancare_Activty.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    GridView gridView7;
    ArrayList<DataServies> dataList;
    Adcare adcare;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Nails");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mancare_activty);


            gridView7 = findViewById(R.id.gridView7);



        dataList = new ArrayList<>();
        adcare = new Adcare(dataList, this);
        gridView7.setAdapter(adcare);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    DataServies dataServies = dataSnapshot.getValue(DataServies.class);
                    dataList.add(dataServies);
                }
                adcare.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}