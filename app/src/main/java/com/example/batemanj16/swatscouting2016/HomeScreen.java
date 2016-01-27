package com.example.batemanj16.swatscouting2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //How to get a button to more reliably do complex functions
        final Button btnTest = (Button) findViewById(R.id.btnTest);
        final EditText txtTime = (EditText) findViewById(R.id.txtField);
        final EditText txtTimeElapsed = (EditText) findViewById(R.id.txtTimeElapsed);

        final String startTime = "030702";


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTime.setText(Time.getCurrentTimeStamp());
                txtTimeElapsed.setText(Time.getTimeElapsed(startTime));



            }
        });


    }

}
