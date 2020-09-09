package com.scheduler.test;

import com.schedule.util.Time;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;


public class TimeTest {




    @Test
    public void testConstructorPositiveTC() {

        Time time = new Time("12:00");

        System.out.println("Inside testConstructorPositiveTC()");
        assertEquals("12:00", time.getTimeAsString());
    }
    @Test
    public void testConstructorNegativeTC() {

        Time time = new Time("12:00");

        System.out.println("Inside testConstructorNegativeTC()");
        assertEquals("13:00", time.getTimeAsString());
    }

    @Test
    public void testTimeDifference1() {

        Time time1 = new Time("12:00");
        Time time2 = new Time("12:00");



        System.out.println("Inside testTimeDifference1()"+Time.getTimeDiffernce(time1,time2));
        assertEquals(0, Time.getTimeDiffernce(time1,time2));
    }
    @Test
    public void testTimeDifference2() {

        Time time1 = new Time("12:00");
        Time time2 = new Time("13:00");



        System.out.println("Inside testTimeDifference2()"+Time.getTimeDiffernce(time1,time2));
        assertEquals(60, Time.getTimeDiffernce(time1,time2));
    }
    @Test
    public void testTimeDifference3() {

        Time time1 = new Time("12:20");
        Time time2 = new Time("13:00");



        System.out.println("Inside testTimeDifference3()"+Time.getTimeDiffernce(time1,time2));
        assertEquals(40, Time.getTimeDiffernce(time1,time2));
    }


}

