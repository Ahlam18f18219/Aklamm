package com.example.ahlammprojecttt;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.DatagramPacket;
import java.time.Instant;

public class Servies_Admin extends AppCompatActivity {
    private ImageView uploudimage;
    EditText Uploudname, uploddescription, uploudPrice;
    Button Addserv;

    private Uri imageUri;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Images");
    final private StorageReference storageReference = FirebaseStorage.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servies_admin);

        Addserv = findViewById(R.id.Addserv);
        uploddescription = findViewById(R.id.uploddescription);
        uploudPrice = findViewById(R.id.uploudPrice);
        Uploudname = findViewById(R.id.Uploudname);
        uploudimage = findViewById(R.id.uploudimage);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            imageUri = data.getData();
                            uploudimage.setImageURI(imageUri);
                        } else {
                            Toast.makeText(Servies_Admin.this, "No image", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );


        uploudimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        Addserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri != null) {
                    uploadToFirebase(imageUri);

                } else {
                    Toast.makeText(Servies_Admin.this, "please select image", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void uploadToFirebase(Uri uri) {
        String name = Uploudname.getText().toString();
        String Price = uploudPrice.getText().toString();
        String Description = uploddescription.getText().toString();
        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Images")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(Servies_Admin.this);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        DataServies dataServies = new DataServies(uri.toString(), name, Price,Description);
                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(dataServies);
                        Toast.makeText(Servies_Admin.this, "Uploud image", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Servies_Admin.this, Servies_Activety.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Servies_Admin.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri fileUri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fileUri));
    }
}