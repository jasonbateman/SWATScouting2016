package com.example.batemanj16.swatscouting2016;

import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Time {


    public static String startTime = "000000";
    public Boolean isTimerRunning = false;
    public Boolean isFirstTimerLoop = true;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //initialize the Timer
            if (isFirstTimerLoop) {
                isFirstTimerLoop = false;
                isTimerRunning = true;
                setStartTime();
                Log.d("Timer", "Started!");
            }



            if (isTimerRunning) {
                handler.postDelayed(this, 500);

            }
        }
    };


    public static String getCurrentTimeStamp(){
        SimpleDateFormat s = new SimpleDateFormat("hhmmss");
        String format = s.format(new Date());
        return format;

    }

    public static String getTimeElapsed(){

        SimpleDateFormat newTimeFormat = new SimpleDateFormat("hhmmss");
        String newTime = newTimeFormat.format(new Date());
        int timeElapsed = Integer.parseInt(newTime.toString()) - Integer.parseInt(startTime.toString());
        Integer.toString(timeElapsed);
        return Integer.toString(timeElapsed);

    }

    public static void setStartTime(){
        startTime = getCurrentTimeStamp();
    }

    public void startMatch(DBHandler dbHandler, String teamNumber, String matchNumber, Boolean defense){
        isFirstTimerLoop = true;
        runnable.run();

        Match match = new Match(dbHandler.getMatchesCount(),
                Integer.parseInt(matchNumber),
                Integer.parseInt(teamNumber),
                defense,
                "",
                100,
                0,
                false,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0

        );
        dbHandler.createMatch(match);

    }

    public void stopTimer() {
        isTimerRunning = false;


    }

}
