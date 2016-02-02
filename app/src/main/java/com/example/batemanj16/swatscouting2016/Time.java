package com.example.batemanj16.swatscouting2016;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Time {

    public static String startTime = "000000";


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

}
