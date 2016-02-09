package com.example.batemanj16.swatscouting2016;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class HomeScreen extends AppCompatActivity {

    EditText editText;
    Export export;
    static final String folder_main = "Scouting2016";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //How to get a button to more reliably do complex functions

        final String startTime = "030702";
        final Button btn_export = (Button) findViewById(R.id.btn_export);
/*
        //Listening for OnClick Activity
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTime.setText(Time.getCurrentTimeStamp());
                txtTimeElapsed.setText(Time.getTimeElapsed());
            }
        });

        //Another Button Listener
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Time.setStartTime();
            }
        });*/
        btn_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExternalStorageWritable()) {

                }
            }
        });

        //Create PUBLIC scouting folder
        //Confirmed Working Below...
        File f = new File(Environment.getExternalStorageDirectory(),
                folder_main);
        if (!f.exists()) {
            f.mkdirs();
        }


    }

    public void btn2ScoutScreen(View view) {
        Intent intent = new Intent(this, scoutScreen.class);

        startActivity(intent);

    }


    private void exportDB(String database) {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String currentDBPath = "/data/" + "com.smithvillehighrobotics.android.frc2015scouting" + "/databases/" + database;
        String backupDBPath = database;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd + "/" + folder_main, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(this, "Database Exported!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        } else {
            return false;
        }
    }
}