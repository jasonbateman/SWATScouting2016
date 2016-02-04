package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class scoutScreen extends AppCompatActivity {
    Boolean portcullis = false;
    Boolean cheval = false;
    Boolean moat = false;
    Boolean ramparts = false;
    Boolean draw = false;
    Boolean sally = false;
    Boolean rock = false;
    Boolean rough = false;
    Boolean logBool = false;

    boolean toAutoScreen = false;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);

        final Spinner spn_df1 = (Spinner) findViewById(R.id.spn_df1);
        final Spinner spn_df2 = (Spinner) findViewById(R.id.spn_df2);
        final Spinner spn_df3 = (Spinner) findViewById(R.id.spn_df3);
        final Spinner spn_df4 = (Spinner) findViewById(R.id.spn_df4);
        final Button btn_autoScreen = (Button) findViewById(R.id.btn_autoScreen);

        Runnable setUpListener = new Runnable(){
            @Override
            public void run() {
                Log.d("RUNNABLE RUNNING", "The runnable is running");
                logBool= ((portcullis||cheval)&&(moat||ramparts)&&(draw||sally)&&(rough||rock));
                //checking to see if each defense is represented
                portcullis = ((spn_df1.getSelectedItem().toString()=="Portcullis")||(spn_df2.getSelectedItem().toString()=="Portcullis")||(spn_df3.getSelectedItem().toString()=="Portcullis")||(spn_df4.getSelectedItem().toString()=="Portcullis"));

                cheval = ((spn_df1.getSelectedItem().toString()==getString(R.string.cheval))||(spn_df2.getSelectedItem().toString()==getString(R.string.cheval))||(spn_df3.getSelectedItem().toString()==getString(R.string.cheval))||(spn_df4.getSelectedItem().toString()==getString(R.string.cheval)));

                moat = ((spn_df1.getSelectedItem().toString()=="Moat")||(spn_df2.getSelectedItem().toString()=="Moat")||(spn_df3.getSelectedItem().toString()=="Moat")||(spn_df4.getSelectedItem().toString()=="Moat"));

                ramparts = ((spn_df1.getSelectedItem().toString()=="Ramparts")||(spn_df2.getSelectedItem().toString()=="Ramparts")||(spn_df3.getSelectedItem().toString()=="Ramparts")||(spn_df4.getSelectedItem().toString()=="Ramparts"));

                draw = ((spn_df1.getSelectedItem().toString()=="Drawbridge")||(spn_df2.getSelectedItem().toString()=="Drawbridge")||(spn_df3.getSelectedItem().toString()=="Drawbridge")||(spn_df4.getSelectedItem().toString()=="Drawbridge"));

                sally = ((spn_df1.getSelectedItem().toString()=="Sally Port")||(spn_df2.getSelectedItem().toString()=="Sally Port")||(spn_df3.getSelectedItem().toString()=="Sally Port")||(spn_df4.getSelectedItem().toString()=="Sally Port"));

                rock = ((spn_df1.getSelectedItem().toString()=="Rock Wall")||(spn_df2.getSelectedItem().toString()=="Rock Wall")||(spn_df3.getSelectedItem().toString()=="Rock Wall")||(spn_df4.getSelectedItem().toString()=="Rock Wall"));

                rough = ((spn_df1.getSelectedItem().toString()=="Rough Terrain")||(spn_df2.getSelectedItem().toString()=="Rough Terrain")||(spn_df3.getSelectedItem().toString()=="Rough Terrain")||(spn_df4.getSelectedItem().toString()=="Rough Terrain"));
                Log.d("Valid?", logBool.toString() );

                handler.postDelayed(this, 500);
            }
        };
        btn_autoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((portcullis||cheval)&&(moat||ramparts)&&(draw||sally)&&(rough||rock))&&(toAutoScreen))
                {
                    toAutoScreen = false;
                    Intent intent = new Intent(getApplicationContext(), AutoScouting.class);
                    startActivity(intent);
                }
            }
        });
        setUpListener.run();




    }
    Intent intent = getIntent();


    //Intent that send you to Auto Screen


}

