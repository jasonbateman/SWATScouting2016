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


    public void startMatch(DBHandler dbHandler, String teamNumber, String matchNumber, Boolean defense){

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
