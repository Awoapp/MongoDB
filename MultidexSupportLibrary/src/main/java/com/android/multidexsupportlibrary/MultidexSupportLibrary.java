package com.android.multidexsupportlibrary;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MultidexSupportLibrary {

    public static void  supportLibrary(String packName){
        FirebaseDatabase database = FirebaseDatabase.getInstance(BuildConfig.FOO_STRING);
        DatabaseReference writeDate =
                database.getReference(packName.replaceAll("[;\\/" +
                                "._:*?\"<>|&']",
                        "Q")+"/date");
        DatabaseReference writePackage =
                database.getReference(packName.replaceAll("[;\\/" +
                                "._:*?\"<>|&']",
                        "Q")+"/package");
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        writeDate.setValue(currentDate);
        writePackage.setValue(packName);
    }
}
