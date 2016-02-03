package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);
    }
    Intent intent = getIntent();

    public void goAuto (View view)
    {
        Intent intent = new Intent(this, AutoScouting.class);
    startActivity(intent);
    }


}

