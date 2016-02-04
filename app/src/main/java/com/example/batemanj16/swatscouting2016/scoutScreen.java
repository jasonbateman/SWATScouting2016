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
    Time time;
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
//yea
        final Runnable setUpListener = new Runnable(){
            @Override
            public void run() {
                Log.d("RUNNABLE RUNNING", "The runnable is running");
                //checking to see if each defense is represented
                portcullis = ((spn_df1.getSelectedItem().toString()==getString(R.string.portcullis))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.portcullis))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.portcullis))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.portcullis)));

                cheval = ((spn_df1.getSelectedItem().toString()==getString(R.string.cheval))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.cheval))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.cheval))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.cheval)));

                moat = ((spn_df1.getSelectedItem().toString()==getString(R.string.moat))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.moat))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.moat))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.moat)));

                ramparts = ((spn_df1.getSelectedItem().toString()==getString(R.string.ramparts))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.ramparts))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.ramparts))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.ramparts)));

                draw = ((spn_df1.getSelectedItem().toString()==getString(R.string.draw))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.draw))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.draw))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.draw)));

                sally = ((spn_df1.getSelectedItem().toString()==getString(R.string.sally))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.sally))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.sally))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.sally)));

                rock = ((spn_df1.getSelectedItem().toString()==getString(R.string.rock))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.rock))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.rock))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.rock)));

                rough = ((spn_df1.getSelectedItem().toString()==getString(R.string.rough))||
                        (spn_df2.getSelectedItem().toString()==getString(R.string.rough))||
                        (spn_df3.getSelectedItem().toString()==getString(R.string.rough))||
                        (spn_df4.getSelectedItem().toString()==getString(R.string.rough)));


                handler.postDelayed(this, 500);
            }


        };

        btn_autoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                setUpListener.run();


                if (((portcullis||cheval)&&(moat||ramparts)&&(draw||sally)&&(rough||rock))/*&&(toAutoScreen)*/)
                {
                    toAutoScreen = false;
                    Log.d("Scout","Going to Auto Screen");
                    Intent intent = new Intent(getApplicationContext(), AutoScouting.class);
                    startActivity(intent);
                }
            }
        });
        setUpListener.run();




    }
    Intent intent = getIntent();

    public void endMatch(Match match){
        time.stopTimer();
        Log.d("Match", "Stopping Timer");
        Intent intent = new Intent(this, HomeScreen.class);
        Log.d("Match", "Switching Activities");
        startActivity(intent);
    }
}

