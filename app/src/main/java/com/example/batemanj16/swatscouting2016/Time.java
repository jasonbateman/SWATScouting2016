package com.example.batemanj16.swatscouting2016;

import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Time {

    public static String startTime = "000000";
    boolean isTimerRunning = false;
    boolean isFirstTimerLoop = true;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //initialize the Timer
            if (isFirstTimerLoop) {
                isFirstTimerLoop = false;
                isTimerRunning = true;
                setStartTime();
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
        String test =  Integer.toString(timeElapsed);
        return test;

    }

    public static void setStartTime(){
        startTime = getCurrentTimeStamp();
    }
    public void endMatch() {
        isTimerRunning = false;
    }

}
