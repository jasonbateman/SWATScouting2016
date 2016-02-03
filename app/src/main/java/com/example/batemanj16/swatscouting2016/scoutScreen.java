package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class scoutScreen extends AppCompatActivity {
    Spinner spn_df1 = (Spinner) findViewById(R.id.spn_df1);
    Spinner spn_df2 = (Spinner) findViewById(R.id.spn_df2);
    Spinner spn_df3 = (Spinner) findViewById(R.id.spn_df3);
    Spinner spn_df4 = (Spinner) findViewById(R.id.spn_df4);

    boolean portcullis = false;
    boolean cheval = false;
    boolean moat = false;
    boolean ramparts = false;
    boolean draw = false;
    boolean sally = false;
    boolean rock = false;
    boolean rough = false;

    boolean toAutoScreen = false;

    Handler handler = new Handler();
    Runnable setUpListener = new Runnable(){
        @Override
        public void run() {
            //checking to see if each defense is represented
            portcullis = ((spn_df1.getSelectedItem().toString()=="Portcullis")||(spn_df2.getSelectedItem().toString()=="Portcullis")||(spn_df3.getSelectedItem().toString()=="Portcullis")||(spn_df4.getSelectedItem().toString()=="Portcullis"));
            cheval = ((spn_df1.getSelectedItem().toString()=="Cheval de Frise")||(spn_df2.getSelectedItem().toString()=="Cheval de Frise")||(spn_df3.getSelectedItem().toString()=="Cheval de Frise")||(spn_df4.getSelectedItem().toString()=="Cheval de Frise"));
            moat = ((spn_df1.getSelectedItem().toString()=="Moat")||(spn_df2.getSelectedItem().toString()=="Moat")||(spn_df3.getSelectedItem().toString()=="Moat")||(spn_df4.getSelectedItem().toString()=="Moat"));
            ramparts = ((spn_df1.getSelectedItem().toString()=="Ramparts")||(spn_df2.getSelectedItem().toString()=="Ramparts")||(spn_df3.getSelectedItem().toString()=="Ramparts")||(spn_df4.getSelectedItem().toString()=="Ramparts"));
            draw = ((spn_df1.getSelectedItem().toString()=="Drawbridge")||(spn_df2.getSelectedItem().toString()=="Drawbridge")||(spn_df3.getSelectedItem().toString()=="Drawbridge")||(spn_df4.getSelectedItem().toString()=="Drawbridge"));
            sally = ((spn_df1.getSelectedItem().toString()=="Sally Port")||(spn_df2.getSelectedItem().toString()=="Sally Port")||(spn_df3.getSelectedItem().toString()=="Sally Port")||(spn_df4.getSelectedItem().toString()=="Sally Port"));
            rock = ((spn_df1.getSelectedItem().toString()=="Rock Wall")||(spn_df2.getSelectedItem().toString()=="Rock Wall")||(spn_df3.getSelectedItem().toString()=="Rock Wall")||(spn_df4.getSelectedItem().toString()=="Rock Wall"));
            rough = ((spn_df1.getSelectedItem().toString()=="Rough Terrain")||(spn_df2.getSelectedItem().toString()=="Rough Terrain")||(spn_df3.getSelectedItem().toString()=="Rough Terrain")||(spn_df4.getSelectedItem().toString()=="Rough Terrain"));

            if (((portcullis||cheval)&&(moat||ramparts)&&(draw||sally)&&(rough||rock))&&(toAutoScreen))
            {

            }
            handler.postDelayed(this, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);





    }
    Intent intent = getIntent();


    //Intent that send you to Auto Screen
    public void goAuto ()
    {
        toAutoScreen = true;
    }


}

