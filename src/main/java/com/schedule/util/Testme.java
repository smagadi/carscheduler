package com.schedule.util;

import com.schedule.core.Scheduler;
import com.schedule.domain.Car;
import com.schedule.domain.Student;

import java.util.ArrayList;

public class Testme {



    public static  void main(String[] args)
    {
        //Cars and its capacity
       int totalcars= 3;
        int slotsInCar=3;


     /* ArrayList<Car> carsList= new ArrayList<Car>();
        for(int i=0;i< totalcars ;i++)
        {
            Car car= new Car(i,slotsInCar);
            carsList.add(car);

        }


        //Student and Arrival times

        Student s1 = new Student(1,12.0f);
        Student s2 = new Student(2,12.01f);
        Student s3 = new Student(3,12.05f);
        Student s4 = new Student(4,12.08f);
        Student s5 = new Student(5,12.11f);
        Student s6 = new Student(6,12.20f);

        ArrayList<Student> timeTable = new ArrayList<Student>();
        timeTable.add(s1);
        timeTable.add(s2);
        timeTable.add(s3);
        timeTable.add(s4);
        timeTable.add(s5);
        timeTable.add(s6);

        try {
            Optimizer.optimize(timeTable, carsList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        for(int i=0;i< carsList.size() ;i++)
        {

            carsList.get(i).getCarAndPassengerDetais();

        }*/

//////////Test 2222


        //Cars and its capacity
          totalcars= 1;
          slotsInCar=3;


        ArrayList<Car> carsList1= new ArrayList<Car>();
        for(int i=0;i< totalcars ;i++)
        {
            Car car= new Car(i,slotsInCar);
            carsList1.add(car);

        }

        //Student and Arrival times

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:02");
        Student s311 = new Student(311,"01:04");
        //Student s1311 = new Student(1311,16.45f);



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);

      //  timeTable1.add(s1311);
        ArrayList <Car> optimizedList=null;
        try {
            Scheduler.optimzer(timeTable1, carsList1,slotsInCar);
            for(int i=0;i< carsList1.size() ;i++)
            {

                 carsList1.get(i).getCarAndPassengerDetais();

            }
            System.out.println("==============First List ============");

            //optimizedList= Scheduler.optimize2(carsList1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Student and Arrival times

        //Cars and its capacity
        totalcars= 2;
        slotsInCar=3;

        s111 = new Student(111,"01:01");
        s211 = new Student(211,"01:02");
        s311 = new Student(311,"02:04");
        Student s411 = new Student(411,"2:05");



        timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        //  timeTable1.add(s1311);
         optimizedList=null;
        try {
            Scheduler.optimzer(timeTable1, carsList1,slotsInCar);
            for(int i=0;i< carsList1.size() ;i++)
            {

                carsList1.get(i).getCarAndPassengerDetais();

            }
            System.out.println("==============First List ============");

            //optimizedList= Scheduler.optimize2(carsList1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
