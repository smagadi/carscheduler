package com.schedule.domain;

import com.schedule.util.Time;

import java.util.ArrayList;
import java.util.Comparator;

public class Car {

    private int totalCapacity;
    private int carId;

    public long getCarcost() {
        return carcost;
    }

    public void setCarcost(long carcost) {
        this.carcost = carcost;
    }

    private long  carcost=-1;
    private ArrayList<Student> passengerList = new ArrayList<Student>();

    public int getCarId() {
        return carId;
    }

    public  void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }


    public ArrayList<Student> getPassengerList() {
        return passengerList;
    }

    public Car() {


    }

    public Car(int carId,int totalCapacity) {
        this.carId = carId;
        this.totalCapacity = totalCapacity;

    }


    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void addPassengerToCar(Student student)
    {

            passengerList.add(student);
            carcost=computeCarCost();


    }
    public void addPassengerPositionToCar(Student student,int position)
    {

        passengerList.add(position,student);
        carcost=computeCarCost();


    }

    public void removePassengerFromCar(Student student)
    {

        passengerList.remove(student);
        carcost=computeCarCost();


    }
    public boolean areSlotsRemaining()
    {
        if(totalCapacity>passengerList.size()  )
            return true;
        else
            return false;

    }
    public int slotsRemaining()
    {
        return totalCapacity-passengerList.size();

    }
    public boolean isEmpty()
    {
        if(passengerList.size()==0)
            return true;
        else
            return false;
    }

    public void getCarAndPassengerDetais()
    {
        System.out.println("car ID"+carId);
        if(passengerList.size()>0)
        {
            System.out.println("Total Car wait Time " + carcost + "mins");

            for( int i =0;i<passengerList.size();i++)
            {

                 int studentid = passengerList.get(i).getStudentId();
                System.out.println("Student in Car"+ " "+  carId+"is"+studentid + "came at" + passengerList.get(i).getArrivalTimeAsString()+"waited for "+
                        Time.getTimeDiffernce(passengerList.get(i).getArrivalTime(),passengerList.get(passengerList.size()-1).getArrivalTime())+"  mins");
            }
        }
        else
            System.out.println("No one in the car");

    }
    public long  computeCarCost()
    {
        if(passengerList.size()>0) {
            Time firstPassengerTime = passengerList.get(0).getArrivalTime();
            Time lastPassengerTime = passengerList.get(passengerList.size() - 1).getArrivalTime();

            return Time.getTimeDiffernce(firstPassengerTime, lastPassengerTime);
        }
        else
            return -1;

    }

    public static Comparator<Car> carCostComparator = new Comparator<Car>() {

        public int compare(Car s1, Car s2) {
            int carcost1 = (int)s1.getCarcost();
            int carcost2 = (int)s2.getCarcost();

            //ascending order
            return carcost2-carcost1;

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};



}
