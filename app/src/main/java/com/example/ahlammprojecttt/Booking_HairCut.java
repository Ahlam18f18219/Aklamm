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
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking_HairCut extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.Homee){
            startActivity(new Intent(Booking_HairCut.this,Navgationahlm.class));
        }
        else if (id== R.id.setting) {
            startActivity(new Intent(Booking_HairCut.this, Settingg_Activty.class));
        }
        else if (id== R.id.shopj) {
            startActivity(new Intent(Booking_HairCut.this, Navgationahlm.class));
        }
        else if (id== R.id.inform) {
            startActivity(new Intent(Booking_HairCut.this, Navgationahlm.class));
        }
        else if (id== R.id.logoutt) {
            startActivity(new Intent(Booking_HairCut.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    EditText bookname, bookphone, bookdate, bookservies;

    Button bookingHair;

    FirebaseDatabase database;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_hair_cut);

        bookname = findViewById(R.id.bookname);
        bookphone = findViewById(R.id.bookphone);
        bookdate = findViewById(R.id.bookdate);
        bookservies = findViewById(R.id.bookservies);
        bookingHair = findViewById(R.id.bookingHair);

        bookingHair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Book Hair Cut");

                String name = bookname.getText().toString();
                String phone = bookphone.getText().toString();
                String Date = bookdate.getText().toString();
                String servies = bookservies.getText().toString();

                BookClass bookClass = new BookClass(name, phone, Date, servies);
                reference.child(name).setValue(bookClass);

                Toast.makeText(Booking_HairCut.this, "Confirm Your Booking", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Booking_HairCut.this, Confirm_Activtey.class);
                startActivity(intent);



                Intent intent1 = new Intent(Booking_HairCut.this,Confirm_Activtey.class);

                intent1.putExtra("name",name);
                intent1.putExtra("phone",phone);
                intent1.putExtra("Date",Date);
                intent1.putExtra("servies",servies);
                startActivity(intent1);

            }
        });
    }


    }
