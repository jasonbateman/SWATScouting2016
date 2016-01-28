package com.example.batemanj16.swatscouting2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class HomeScreen extends AppCompatActivity {

    EditText editText;
    Export export;

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


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTime.setText(Time.getCurrentTimeStamp());
                txtTimeElapsed.setText(Time.getTimeElapsed(startTime));
                writeExternalStorage();


            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    public void writeExternalStorage() {
        File file = new File(getApplicationContext().getFilesDir(), "Database.sql");


    }
}
