package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class AutoScouting extends AppCompatActivity {



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
        final TextView txt_scoreStatus = (TextView) findViewById(R.id.txt_dfStatus);
    }


   public void refresh(Switch switch_spy, Switch switch_cross, Switch switch_reach, Switch switch_low, Switch switch_high, TextView txt_position, TextView txt_dfStatus){

        if(!switch_spy.isChecked()){
            txt_position.setText("Middle Position");
        }
        else{
            txt_position.setText("Spy Bot");
        }

        if(switch_cross.isChecked()){
            txt_dfStatus.setText("RCross Defense");
        }
        else if(switch_reach.isChecked()){
            txt_dfStatus.setText("Reached Defense");
        }
        else{
            txt_dfStatus.setText("No interaction");
        }

    }
}
