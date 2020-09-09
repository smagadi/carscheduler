package com.schedule.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Time {

    private String time = null;
    public Time(String time) {
        this.time = time;
    }
    public String getTime()
    {
        return time;
    }
    public String getTimeAsString()
    {
        return time;
    }
    public static long getTimeDiffernce(Time start,Time end)
    {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date starttime=null;
        Date endtime=null;
       try {
            starttime = format.parse(start.getTimeAsString());
            endtime = format.parse(end.getTimeAsString());

       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return (endtime.getTime() - starttime.getTime())/(60*1000);
    }
}
