package com.example.batemanj16.swatscouting2016;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    Boolean defense = false;

    Integer spn1;
    Integer spn2;
    Integer spn3;
    Integer spn4;

    Boolean firstLoop = true;
    Boolean allowedToRun = true;
    boolean toAutoScreen = false;
    Handler handler = new Handler();

    String def1 = "";
    String def2 = "";
    String def3 = "";
    String def4 = "";

    boolean lowBarCrossing;
    boolean def2Crossing;
    boolean def3Crossing;
    boolean def4Crossing;
    boolean def5Crossing;

    double startTime;
    double timeToCross;
    public double averageTimeToCross_lowBar;
    public double averageTimeToCross_def2;
    public double averageTimeToCross_def3;
    public double averageTimeToCross_def4;
    public double averageTimeToCross_def5;

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

    int shotsTaken = 0;
    int shotsMade = 0;

    DBHandler dbHandler;

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
        final Button btn_highGoal = (Button) findViewById(R.id.btn_highGoal);
        final Button btn_lowGoal = (Button) findViewById(R.id.btn_lowGoal);
        final Button btn_miss = (Button) findViewById(R.id.btn_miss);
        final Button btn_endMatch = (Button) findViewById(R.id.btn_endMatch);

        final EditText txt_matchNum = (EditText) findViewById(R.id.txt_matchNum);
        final EditText txt_teamNum = (EditText) findViewById(R.id.txt_teamNum);


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
                    Log.d("RUNNABLE RUNNING", "LOOP");
                    //checking to see if each defense is represented
                    Log.d("Loop", "First loop value is " + firstLoop.toString());;

                    if (firstLoop) {
                        if (spn1 == null){
                            spn1 = 0;
                            Log.d("SPN VALUES", "Set the SPN1 value to " + spn1);
                        }
                        if (spn2 == null){
                            spn2 = 2;
                            Log.d("SPN VALUES", "Set the SPN2 value to " + spn2);
                        }
                        if (spn3 == null){
                            spn3 = 4;
                            Log.d("SPN VALUES", "Set the SPN3 value to " + spn3);
                        }
                        if (spn4 == null){
                            spn4 = 6;
                            Log.d("SPN VALUES", "Set the SPN4 value to " + spn4);
                        }

                        spn_df1.setSelection(spn1);
                        spn_df2.setSelection(spn2);
                        spn_df3.setSelection(spn3);
                        spn_df4.setSelection(spn4);
                        firstLoop = false;
                        Log.d("First LOOP", "run");
                    }
                    else {
                        Log.d("First LOOP", "not run");
                    }
                    portcullis = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.portcullis))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.portcullis))));
                    if (portcullis){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.portcullis)))){
                            def1 = getString(R.string.portcullis);
                            spn1 = 0;
                            Log.d("First Spinner", "Set the spn1 to Portcullis and the value of the spinner is " + spn1);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.portcullis))){
                            def2 = getString(R.string.portcullis);
                            spn2 = 0;
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.portcullis))){
                            def3 = getString(R.string.portcullis);
                            spn3 = 0;
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.portcullis))){
                            def4 = getString(R.string.portcullis);
                            spn4 = 0;
                        }
                    }

                    cheval = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.cheval))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.cheval))));
                    if (cheval){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.cheval)))){
                            def1 = getString(R.string.cheval);
                            spn1 = 1;
                            Log.d("First Spinner", "Set the spn1 to Cheval and the value of the spinner is " + spn1);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.cheval))){
                            def2 = getString(R.string.cheval);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.cheval))){
                            def3 = getString(R.string.cheval);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.cheval))){
                            def4 = getString(R.string.cheval);
                        }
                    }

                    moat = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.moat))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.moat))));
                    if (moat){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.moat)))){
                            def1 = getString(R.string.moat);
                        }
                        else if(spn_df2.getSelectedItem().toString().equals(getString(R.string.moat))){
                            def2 = getString(R.string.moat);
                        }
                        else if(spn_df3.getSelectedItem().toString().equals(getString(R.string.moat))){
                            def3 = getString(R.string.moat);
                        }
                        else if(spn_df4.getSelectedItem().toString().equals(getString(R.string.moat))){
                            def4 = getString(R.string.moat);
                        }
                    }

                    ramparts = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.ramparts))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.ramparts))));
                    if (ramparts){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.ramparts)))){
                            def1 = getString(R.string.ramparts);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.ramparts))){
                            def2 = getString(R.string.ramparts);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.ramparts))){
                            def3 = getString(R.string.ramparts);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.ramparts))){
                            def4 = getString(R.string.ramparts);
                        }
                    }

                    draw = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.draw))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.draw))));
                    if (portcullis){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.draw)))){
                            def1 = getString(R.string.draw);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.draw))){
                            def2 = getString(R.string.draw);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.draw))){
                            def3 = getString(R.string.draw);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.draw))){
                            def4 = getString(R.string.draw);
                        }
                    }

                    sally = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.sally))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.sally))));
                    if (portcullis){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.sally)))){
                            def1 = getString(R.string.sally);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.sally))){
                            def2 = getString(R.string.sally);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.sally))){
                            def3 = getString(R.string.sally);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.sally))){
                            def4 = getString(R.string.sally);
                        }
                    }

                    rock = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.rock))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.rock))));
                    if (portcullis){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rock)))){
                            def1 = getString(R.string.rock);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.rock))){
                            def2 = getString(R.string.rock);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.rock))){
                            def3 = getString(R.string.rock);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.rock))){
                            def4 = getString(R.string.rock);
                        }
                    }

                    rough = ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df2.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df3.getSelectedItem().toString().equals(getString(R.string.rough))) ||
                            (spn_df4.getSelectedItem().toString().equals(getString(R.string.rough))));
                    if (portcullis){
                        if ((spn_df1.getSelectedItem().toString().equals(getString(R.string.rough)))){
                            def1 = getString(R.string.rough);
                        }
                        if(spn_df2.getSelectedItem().toString().equals(getString(R.string.rough))){
                            def2 = getString(R.string.rough);
                        }
                        if(spn_df3.getSelectedItem().toString().equals(getString(R.string.rough))){
                            def3 = getString(R.string.rough);
                        }
                        if(spn_df4.getSelectedItem().toString().equals(getString(R.string.rough))){
                            def4 = getString(R.string.rough);
                        }
                    }
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
        btn_endMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // endMatch(submitMatch(dbHandler, txt_matchNum.getText(), txt_teamNum.getText(), defense, shotsTaken, spn_df1.getSelectedItem().toString(), spn_df2.getSelectedItem().toString(), spn_df3.getSelectedItem().toString(), spn_df4.getSelectedItem().toString()));
            }
        });

        btn_lowBarCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lowBarCrossing && !def2Crossing && !def3Crossing && !def4Crossing && !def5Crossing){
                    //you're not yet crossing a defense
                    startTime = System.currentTimeMillis();
                    lowBarCrossing = true;
                }else if(lowBarCrossing){
                    //you finished your cross

                    timesCrossed_lowBar++;


                    timeToCross = System.currentTimeMillis() - startTime;


                    timeToCrossList_lowBar.add(timeToCross);
                    averageTimeToCross_lowBar  = (averageTimeToCross_lowBar*(timesCrossed_lowBar-1)+ timeToCross)/timesCrossed_lowBar;
                    lowBarCrossing = false;

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
                    averageTimeToCross_def2 = (averageTimeToCross_def2*(timesCrossed_def2-1)+timeToCross)/timesCrossed_def2;
                    def2Crossing = false;
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
                    averageTimeToCross_def3 = (averageTimeToCross_def3*(timesCrossed_def3-1)+timeToCross)/timesCrossed_def3;
                    def3Crossing = false;
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
                    averageTimeToCross_def4 = (averageTimeToCross_def4*(timesCrossed_def4-1)+timeToCross)/timesCrossed_def4;
                    def4Crossing = false;
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
                    averageTimeToCross_def5 = (averageTimeToCross_def5*(timesCrossed_def5-1)+timeToCross)/timesCrossed_def5;
                    def5Crossing = false;

                }

            }
        });

        btn_highGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shotsTaken++;
                shotsMade++;

            }
        });

        btn_lowGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shotsTaken++;
                shotsMade++;

            }
        });

        btn_miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shotsTaken++;

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
        Log.d("Match", "Stopping Timer");
        Intent intent = new Intent(this, HomeScreen.class);
        Log.d("Match", "Switching Activities");
        startActivity(intent);
    }


    public static String getCurrentTimeStamp(){
        SimpleDateFormat s = new SimpleDateFormat("hhmmss");
        String format = s.format(new Date());
        return format;

    }

    public static String getTimeElapsed(Integer startTime){

        SimpleDateFormat newTimeFormat = new SimpleDateFormat("hhmmss");
        String newTime = newTimeFormat.format(new Date());
        int timeElapsed = Integer.parseInt(newTime.toString()) - Integer.parseInt(startTime.toString());
        Integer.toString(timeElapsed);
        return Integer.toString(timeElapsed);

    }

    public Match submitMatch(DBHandler dbHandler, String teamNumber, String matchNumber, Boolean defense, int shotsTaken, String spn_df1, String spn_df2, String spn_df3, String spn_df4){

        double _avgPort = 0;
        double _avgCheval =0;
        double _avgMoat=0;
        double _avgRamp=0;
        double _avgDraw=0;
        double _avgSally=0;
        double _avgRough=0;
        double _avgRock=0;

        int  _numPort= 0;
        int _numCheval = 0;
        int _numMoat = 0;
        int _numRamp = 0;
        int _numDraw = 0;
        int _numSally = 0;
        int _numRough = 0;
        int _numRock = 0;


        switch (spn_df1){
            case "Portcullis":
                _avgPort = averageTimeToCross_def2;
                _numPort = timesCrossed_def2;
                break;
            case "Cheval":
                _avgCheval = averageTimeToCross_def2;
                _numCheval = timesCrossed_def2;
                break;
            case "Moat":
                _avgMoat = averageTimeToCross_def2;
                _numMoat = timesCrossed_def2;
                break;
            case "Ramp":
                _avgRamp = averageTimeToCross_def2;
                _numRamp = timesCrossed_def2;
                break;
            case "Draw":
                _avgDraw = averageTimeToCross_def2;
                _numDraw = timesCrossed_def2;
                break;
            case "Sally":
                _avgSally = averageTimeToCross_def2;
                _numSally = timesCrossed_def2;
                break;
            case "Rough":
                _avgRough = averageTimeToCross_def2;
                _numRough = timesCrossed_def2;
                break;
            case "Rock":
                _avgRock = averageTimeToCross_def2;
                _numRock = timesCrossed_def2;
                break;
        }
        switch (spn_df2){
            case "Portcullis":
                _avgPort = averageTimeToCross_def3;
                _numPort = timesCrossed_def3;
                break;
            case "Cheval":
                _avgCheval = averageTimeToCross_def3;
                _numCheval = timesCrossed_def3;
                break;
            case "Moat":
                _avgMoat = averageTimeToCross_def3;
                _numMoat = timesCrossed_def3;
                break;
            case "Ramp":
                _avgRamp = averageTimeToCross_def3;
                _numRamp = timesCrossed_def3;
                break;
            case "Draw":
                _avgDraw = averageTimeToCross_def3;
                _numDraw = timesCrossed_def3;
                break;
            case "Sally":
                _avgSally = averageTimeToCross_def3;
                _numSally = timesCrossed_def3;
                break;
            case "Rough":
                _avgRough = averageTimeToCross_def3;
                _numRough = timesCrossed_def3;
                break;
            case "Rock":
                _avgRock = averageTimeToCross_def3;
                _numRock = timesCrossed_def3;
                break;
        }
        switch (spn_df3){
            case "Portcullis":
                _avgPort = averageTimeToCross_def4;
                _numPort = timesCrossed_def4;
                break;
            case "Cheval":
                _avgCheval = averageTimeToCross_def4;
                _numCheval = timesCrossed_def4;
                break;
            case "Moat":
                _avgMoat = averageTimeToCross_def4;
                _numMoat = timesCrossed_def4;
                break;
            case "Ramp":
                _avgRamp = averageTimeToCross_def4;
                _numRamp = timesCrossed_def4;
                break;
            case "Draw":
                _avgDraw = averageTimeToCross_def4;
                _numDraw = timesCrossed_def4;
                break;
            case "Sally":
                _avgSally = averageTimeToCross_def4;
                _numSally = timesCrossed_def4;
                break;
            case "Rough":
                _avgRough = averageTimeToCross_def4;
                _numRough = timesCrossed_def4;
                break;
            case "Rock":
                _avgRock = averageTimeToCross_def4;
                _numRock = timesCrossed_def4;
                break;
        }
        switch (spn_df4){
            case "Portcullis":
                _avgPort = averageTimeToCross_def5;
                _numPort = timesCrossed_def5;
                break;
            case "Cheval":
                _avgCheval = averageTimeToCross_def5;
                _numCheval = timesCrossed_def5;
                break;
            case "Moat":
                _avgMoat = averageTimeToCross_def5;
                _numMoat = timesCrossed_def5;
                break;
            case "Ramp":
                _avgRamp = averageTimeToCross_def5;
                _numRamp = timesCrossed_def5;
                break;
            case "Draw":
                _avgDraw = averageTimeToCross_def5;
                _numDraw = timesCrossed_def5;
                break;
            case "Sally":
                _avgSally = averageTimeToCross_def5;
                _numSally = timesCrossed_def5;
                break;
            case "Rough":
                _avgRough = averageTimeToCross_def5;
                _numRough = timesCrossed_def5;
                break;
            case "Rock":
                _avgRock = averageTimeToCross_def5;
                _numRock = timesCrossed_def5;
                break;
        }


        if (shotsTaken!=0){
            shotsTaken = 300;
        }//TODO: FINISH THIS

        Match match = new Match(dbHandler.getMatchesCount(),
                Integer.parseInt(matchNumber),
                Integer.parseInt(teamNumber),
                defense,
                "",
                100,         //accuracy
                0,          //shotsTaken
                false,      //climb
                0,          //fouls
                _avgPort,          //avgport
                _avgCheval,
                _avgMoat,
                _avgRamp,
                _avgDraw,
                _avgSally,
                _avgRough,
                _avgRock,
                averageTimeToCross_lowBar,          //avgLow
                _numPort,
                _numCheval,
                _numMoat,
                _numRamp,
                _numDraw,
                _numSally,
                _numRough,
                _numRock,
                timesCrossed_lowBar

        );
        dbHandler.createMatch(match);
        return match;
    }

}



