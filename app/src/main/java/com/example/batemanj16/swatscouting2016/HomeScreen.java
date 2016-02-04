package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
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
        });
*/
        //Create PUBLIC scouting folder
        //Confirmed Working Below...
        File f = new File(Environment.getExternalStorageDirectory(),
                folder_main);
        if (!f.exists()) {
            f.mkdirs();
        }


    }

    public void btn2ScoutScreen(View view){
        Intent intent = new Intent(this, scoutScreen.class);

        startActivity(intent);

    }



}

