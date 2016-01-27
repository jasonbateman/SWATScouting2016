package com.example.batemanj16.swatscouting2016;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Time {

    public static String getCurrentTimeStamp(){
        SimpleDateFormat s = new SimpleDateFormat("hhmmss");
        String format = s.format(new Date());
        return format;

    }

    public static String getTimeElapsed(String startTime){

        SimpleDateFormat newTimeFormat = new SimpleDateFormat("hhmmss");
        String newTime = newTimeFormat.format(new Date());
        int timeElapsed = Integer.parseInt(newTime) - Integer.parseInt(startTime);
        return Integer.toString(timeElapsed);

    }

}
