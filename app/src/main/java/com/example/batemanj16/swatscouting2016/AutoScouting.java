package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class AutoScouting extends AppCompatActivity {
    Intent intent = getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_scouting);


        final Switch switch_spy = (Switch) findViewById(R.id.switch_spy);
        final Switch switch_reach = (Switch) findViewById(R.id.switch_reach);
        final Switch switch_cross = (Switch) findViewById(R.id.switch_cross);
        final Switch switch_low = (Switch) findViewById(R.id.switch_low);
        final Switch switch_high = (Switch) findViewById(R.id.switch_high);
        final TextView txt_position = (TextView) findViewById(R.id.txt_position);
        final TextView txt_dfStatus = (TextView) findViewById(R.id.txt_dfStatus);
        final TextView txt_scoreStatus = (TextView) findViewById(R.id.txt_scoreStatus);
        final Button btn_endAuto = (Button) findViewById(R.id.btn_endAuto);


        switch_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh(switch_spy, switch_cross, switch_reach, switch_low, switch_high, txt_position, txt_dfStatus, txt_scoreStatus);
            }
        });
        switch_spy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh(switch_spy, switch_cross, switch_reach, switch_low, switch_high, txt_position, txt_dfStatus, txt_scoreStatus);
            }
        });
        switch_reach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh(switch_spy, switch_cross, switch_reach, switch_low, switch_high, txt_position, txt_dfStatus, txt_scoreStatus);
            }
        });
        switch_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh(switch_spy, switch_cross, switch_reach, switch_low, switch_high, txt_position, txt_dfStatus, txt_scoreStatus);
            }
        });
        switch_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh(switch_spy, switch_cross, switch_reach, switch_low, switch_high, txt_position, txt_dfStatus, txt_scoreStatus);
            }
        });
        btn_endAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), scoutScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }


   public void refresh(Switch switch_spy, Switch switch_cross, Switch switch_reach, Switch switch_low, Switch switch_high, TextView txt_position, TextView txt_dfStatus, TextView txt_scoreStatus){

        if(!switch_spy.isChecked()){
            txt_position.setText("Middle Position");
        }
        else{
            txt_position.setText("Spy Bot");
        }

        if(switch_cross.isChecked()){
            txt_dfStatus.setText("Cross Defense");
        }
        else if(switch_reach.isChecked()){
            txt_dfStatus.setText("Reached Defense");
        }
        else{
            txt_dfStatus.setText("No interaction");
        }

       if(switch_high.isChecked()){
           txt_scoreStatus.setText("High shot");
       }
       else if(switch_low.isChecked()){
           txt_scoreStatus.setText("Low Ball");
       }
       else{
           txt_scoreStatus.setText("No Score");
       }

    }
}
