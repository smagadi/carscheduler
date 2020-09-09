package com.schedule.domain;

import com.schedule.util.Time;

public class Student {

   private int studentId;
   private Time arrivalTime;
   private String arrivalTimeAsString;

    public Student(int studentId, String arrivalTime) {
        this.studentId = studentId;
        this.arrivalTime = new Time(arrivalTime);
        this.arrivalTimeAsString=arrivalTime;
    }


    public int getStudentId() {
        return studentId;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeAsString() {
        return arrivalTimeAsString;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
