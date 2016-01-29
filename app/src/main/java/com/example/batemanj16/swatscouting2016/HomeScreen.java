package com.example.batemanj16.swatscouting2016;

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
        final Button btnTest = (Button) findViewById(R.id.btnWrite);
        final Button btnRead = (Button) findViewById(R.id.btnRead);
        final EditText txtTime = (EditText) findViewById(R.id.txtField);
        final EditText txtTimeElapsed = (EditText) findViewById(R.id.txtTimeElapsed);

        final String startTime = "030702";

        //Listening for OnClick Activity
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTime.setText(Time.getCurrentTimeStamp());
                txtTimeElapsed.setText(Time.getTimeElapsed(startTime));
                exportDB("Scouting.db");



            }
        });

        //Another Button Listener
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    private void exportDB(String database){
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source= null;
        FileChannel destination= null;
        String currentDBPath = "com.example.batemanj16.swatscouting2016" +"/databases/" + database;
        String backupDBPath = database;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd+ "/" +folder_main, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(this, "Database Exported!", Toast.LENGTH_SHORT).show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
