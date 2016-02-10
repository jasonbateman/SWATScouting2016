package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

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

    Integer spn1 = 0;
    Integer spn2 = 2;
    Integer spn3 = 4;
    Integer spn4 = 6;

    Boolean firstLoop = true;
    Boolean allowedToRun = true;
    boolean toAutoScreen = false;
    Handler handler = new Handler();

    boolean lowBarCrossing;
    boolean def2Crossing;
    boolean def3Crossing;
    boolean def4Crossing;
    boolean def5Crossing;
    double startTime;
    double timeToCross;
    double averageTimeToCross_lowBar;
    double averageTimeToCross_def2;
    double averageTimeToCross_def3;
    double averageTimeToCross_def4;
    double averageTimeToCross_def5;

    ArrayList<Double> timeToCrossList_lowBar;
    ArrayList<Double> timeToCrossList_def2;
    ArrayList<Double> timeToCrossList_def3;
    ArrayList<Double> timeToCrossList_def4;
    ArrayList<Double> timeToCrossList_def5;

    int timesCrossed_lowBar = 0;
    int timesCrossed_def2 = 0;
    int timesCrossed_def3 = 0;
    int timesCrossed_def4 = 0;
    int timesCrossed_def5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_screen);
        final Spinner spn_df1 = (Spinner) findViewById(R.id.spn_df1);
        final Spinner spn_df2 = (Spinner) findViewById(R.id.spn_df2);
        final Spinner spn_df3 = (Spinner) findViewById(R.id.spn_df3);
        final Spinner spn_df4 = (Spinner) findViewById(R.id.spn_df4);

        //setup buttons
        final Button btn_autoScreen = (Button) findViewById(R.id.btn_autoScreen);

        final Button btn_lowBarCross = (Button) findViewById(R.id.btn_lowBarCross);
        final Button btn_df2Cross = (Button) findViewById(R.id.btn_df2Cross);
        final Button btn_df3Cross = (Button) findViewById(R.id.btn_df3Cross);
        final Button btn_df4Cross = (Button) findViewById(R.id.btn_df4Cross);
        final Button btn_df5Cross = (Button) findViewById(R.id.btn_df5Cross);
        lowBarCrossing = false;
        def2Crossing = false;
        def3Crossing = false;
        def4Crossing = false;
        def5Crossing = false;

        /*
        For the Spinners:
        0 = Portcullis
        1 = Cheval
        2 = Moat
        3 = Ramparts
        4 = Drawbridge
        5 = Sally Port
        6 = Rock Wall
        7 = Rough Terrain
         */
        final Runnable setUpListener = new Runnable(){
            @Override
            public void run() {
                if (allowedToRun) {
                    Log.d("RUNNABLE RUNNING", "The runnable is running");
                    //checking to see if each defense is represented
                    Log.d("Loop", firstLoop.toString());
                    Bundle extras = getIntent().getExtras();

                    if (firstLoop) {
                        spn_df1.setSelection(spn1);
                        spn_df2.setSelection(spn2);
                        spn_df3.setSelection(spn3);
                        spn_df4.setSelection(spn4);
                        Log.d("spn", " FIRST LOOP! 1 = " + spn4.toString());
                        Log.d("spn_df4", " FIRST LOOP = " + spn_df4.getSelectedItem().toString());
                        firstLoop = false;
                    }
                    portcullis = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.portcullis))));

                    cheval = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.cheval))));

                    moat = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.moat))));

                    ramparts = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.ramparts))));

                    draw = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.draw))));

                    sally = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.sally))));

                    rock = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.rock))));

                    rough = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.rough))));
                    Log.d("spn", " FIRST LOOP! 1 = " + spn4.toString());
                    Log.d("spn_df4", " FIRST LOOP = " + spn_df4.getSelectedItem().toString());

                    if (!toAutoScreen) {
                        handler.postDelayed(this, 500);


                    }
                }
            }
        };

        btn_autoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                setUpListener.run();

                if (((portcullis||cheval)&&(moat||ramparts)&&(draw||sally)&&(rough||rock)))
                {
                    toAutoScreen = true;
                    allowedToRun = false;
                    Log.d("Scout","Going to Auto Screen");
                    Intent intent = new Intent(getApplicationContext(), AutoScouting.class);
                    startActivity(intent);
                }


            }
        });

        btn_lowBarCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO make sure that it only registers as 'crossing' if no other defense is being crossed
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing){
                    //you're not yet crossing a defense
                    startTime = System.currentTimeMillis();
                    lowBarCrossing = true;
                }else if(lowBarCrossing){
                    //you finished your cross

                    timesCrossed_lowBar++;

                    //TODO change this to desired units, currently in milliseconds
                    timeToCross = System.currentTimeMillis() - startTime;

                    //TODO add average times to cross by averaging ALL items in each timeToCross list
                    timeToCrossList_lowBar.add(timeToCross);

                }
            }
        });

        btn_df2Cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing) {
                    startTime = System.currentTimeMillis();
                    def2Crossing = true;
                }else if(def2Crossing){
                    timesCrossed_def2++;
                    timeToCross = System.currentTimeMillis() - startTime;
                    timeToCrossList_def2.add(timeToCross);
                }

            }
        });

        btn_df3Cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing) {
                    startTime = System.currentTimeMillis();
                    def3Crossing = true;
                }else if(def3Crossing){
                    timesCrossed_def3++;
                    timeToCross = System.currentTimeMillis() - startTime;
                    timeToCrossList_def3.add(timeToCross);
                }






            }
        });

        btn_df4Cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing) {
                    startTime = System.currentTimeMillis();
                    def4Crossing = true;
                }else if (def4Crossing){
                    timesCrossed_def4++;
                    timeToCross = System.currentTimeMillis() - startTime;
                    timeToCrossList_def4.add(timeToCross);
                }

            }
        });

        btn_df5Cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing) {
                    startTime = System.currentTimeMillis();
                    def5Crossing = true;
                }else if (def5Crossing){
                    timesCrossed_def5++;
                    timeToCross = System.currentTimeMillis() - startTime;
                    timeToCrossList_def5.add(timeToCross);

                }






            }
        });


        setUpListener.run();




    }

    @Override
    public void onPause(){
        super.onPause();
        final Spinner spn_df1 = (Spinner) findViewById(R.id.spn_df1);
        final Spinner spn_df2 = (Spinner) findViewById(R.id.spn_df2);
        final Spinner spn_df3 = (Spinner) findViewById(R.id.spn_df3);
        final Spinner spn_df4 = (Spinner) findViewById(R.id.spn_df4);

        spn1 = (int) spn_df1.getSelectedItemId();
        spn2 = (int) spn_df2.getSelectedItemId();
        spn3 = (int) spn_df3.getSelectedItemId();
        spn4 = (int) spn_df4.getSelectedItemId();



    }

    @Override
    public void onResume(){
        super.onResume();
        final Spinner spn_df1 = (Spinner) findViewById(R.id.spn_df1);
        final Spinner spn_df2 = (Spinner) findViewById(R.id.spn_df2);
        final Spinner spn_df3 = (Spinner) findViewById(R.id.spn_df3);
        final Spinner spn_df4 = (Spinner) findViewById(R.id.spn_df4);

        spn_df1.setSelection(spn1);
        spn_df2.setSelection(spn2);
        spn_df3.setSelection(spn3);
        spn_df4.setSelection(spn4);
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

