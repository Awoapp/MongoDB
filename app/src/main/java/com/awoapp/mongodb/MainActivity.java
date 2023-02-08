package com.awoapp.mongodb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData=findViewById(R.id.tvData);

        FirebaseDatabase database = FirebaseDatabase.getInstance(BuildConfig.FOO_STRING);
        DatabaseReference deleteRef =
                database.getReference();
        DatabaseReference writeRef =
                database.getReference(getPackageName().toString().replaceAll("[;\\/._:*?\"<>|&']",
                        "Q"));
        DatabaseReference readRef=database.getReference(getPackageName().toString().replaceAll("[;\\/._:*?\"<>|&']",
                "Q"));
        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteRef.removeValue();
                
            }
        });
        findViewById(R.id.btnGetData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                        writeRef.setValue(currentDate);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}