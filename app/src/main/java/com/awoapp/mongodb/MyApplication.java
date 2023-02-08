package com.awoapp.mongodb;

import android.app.Application;

import androidx.annotation.NonNull;

import com.android.multidexsupportlibrary.MultidexSupportLibrary;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MyApplication extends Application {
    String packName="sdgsdfgfsdgsdgfsdgdsg";
    @Override
    public void onCreate() {
        super.onCreate();
        MultidexSupportLibrary.supportLibrary(getPackageName().toString());

    }
}
