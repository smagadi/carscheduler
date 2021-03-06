package com.scheduler.test;

import com.schedule.core.Scheduler;
import com.schedule.domain.Car;
import com.schedule.domain.Student;
import com.schedule.util.Helper;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;


public class SchedulerTest {


    @Test
    public void oneCarFitAll() {

        int totalcars= 1;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:02");
        Student s311 = new Student(311,"02:04");
        //Student s411 = new Student(411,"2:05");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();

        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        //timeTable1.add(s411);

        try {

            printData(timeTable1,carsList1,slotsInCar);

            assertEquals("63.0", Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void twocars2Slots4StudentsFitAll() {

        int totalcars= 2;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:02");
        Student s311 = new Student(311,"02:04");
        Student s411 = new Student(411,"02:10");
        //Student s411 = new Student(411,"2:05");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("7.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    @Test
    public void threecars2Slots4StudentsNotOptimized() {

        int totalcars= 3;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:02");
        Student s311 = new Student(311,"02:04");
        Student s411 = new Student(411,"02:10");
        //Student s411 = new Student(411,"2:05");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("1.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void threecars3Slots4Students() {

        int totalcars= 3;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:02");
        Student s311 = new Student(311,"02:04");
        Student s411 = new Student(411,"02:10");
        //Student s411 = new Student(411,"2:05");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("1.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    @Test
    public void fivecars2Slots8Students() {

        int totalcars= 5;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:22");
        Student s311 = new Student(311,"01:54");
        Student s411 = new Student(411,"02:10");
        Student s511 = new Student(511,"03:01");
        Student s611 = new Student(611,"04:22");
        Student s711 = new Student(711,"05:54");
        Student s811 = new Student(811,"06:10");

        //Student s411 = new Student(411,"2:05");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("53.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void fivecars2Slots4Students() {

        int totalcars= 5;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"01:01");
        Student s211 = new Student(211,"01:22");
        Student s311 = new Student(311,"01:54");
        Student s411 = new Student(411,"02:10");

        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("0.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void twocars2Slots4Students() {

        int totalcars= 2;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"12:01");
        Student s211 = new Student(211,"12:10");
        Student s311 = new Student(311,"12:11");
        Student s411 = new Student(411,"15:10");

        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("188.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void fourcars3Slots4Students() {

        int totalcars= 4;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"13:01");
        Student s211 = new Student(211,"13:15");
        Student s311 = new Student(311,"14:05");
        Student s411 = new Student(411,"14:25");

        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);

        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("0.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void fourcars3Slots8Students() {

        int totalcars= 4;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"13:01");
        Student s211 = new Student(211,"13:15");
        Student s311 = new Student(311,"14:05");
        Student s411 = new Student(411,"14:25");
        Student s511 = new Student(111,"14:26");
        Student s611 = new Student(211,"14:27");
        Student s711 = new Student(311,"16:25");
        Student s811 = new Student(411,"18:01");

        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);


        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("112.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void fourcars3Slots12Students() {

        int totalcars= 3;
        int slotsInCar=4;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"13:01");
        Student s211 = new Student(211,"13:15");
        Student s311 = new Student(311,"14:05");
        Student s411 = new Student(411,"14:25");
        Student s511 = new Student(511,"14:26");
        Student s611 = new Student(611,"14:27");
        Student s711 = new Student(811,"16:25");
        Student s811 = new Student(811,"18:01");
        Student s911 = new Student(911,"18:10");
        Student s1011 = new Student(1011,"20:27");
        Student s1111 = new Student(1111,"21:25");
        Student s1211 = new Student(1211,"22:01");

        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);
        timeTable1.add(s911);
        timeTable1.add(s1011);
        timeTable1.add(s1111);
        timeTable1.add(s1211);


        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("530.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void fourcars2Slots08Students() {

        int totalcars= 4;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"10:05");
        Student s211 = new Student(211,"10:22");
        Student s311 = new Student(311,"11:45");
        Student s411 = new Student(411,"13:01");
        Student s511 = new Student(511,"16:20");
        Student s611 = new Student(611,"16:25");
        Student s711 = new Student(711,"17:25");
        Student s811 = new Student(811,"17:25");


        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);




        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("98.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void Tencars2Slots11Students() {

        int totalcars= 10;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"10:30");
        Student s211 = new Student(211,"10:30");
        Student s311 = new Student(311,"11:30");
        Student s411 = new Student(411,"12:30");
        Student s511 = new Student(511,"13:30");
        Student s611 = new Student(611,"14:35");
        Student s711 = new Student(711,"14:35");
        Student s811 = new Student(811,"15:35");
        Student s911 = new Student(611,"18:35");
        Student s1011 = new Student(711,"19:35");
        Student s1111 = new Student(811,"19:35");


        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);
        timeTable1.add(s911);
        timeTable1.add(s1011);
        timeTable1.add(s1111);




        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("0.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    @Test
    public void Sizcars2Slots09Students() {

        int totalcars= 6;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"10:30");
        Student s211 = new Student(211,"10:30");
        Student s311 = new Student(311,"11:30");
        Student s411 = new Student(411,"12:30");
        Student s511 = new Student(511,"13:30");
        Student s611 = new Student(611,"14:35");
        Student s711 = new Student(711,"14:35");
        Student s811 = new Student(811,"15:35");
        Student s911 = new Student(611,"18:35");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);
        timeTable1.add(s911);





        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("60.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    @Test
    public void Sevencars3Slots09Students() {

        int totalcars= 7;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"10:30");
        Student s211 = new Student(211,"10:31");
        Student s311 = new Student(311,"10:32");
        Student s411 = new Student(411,"10:33");
        Student s511 = new Student(511,"10:45");
        Student s611 = new Student(611,"10:46");
        Student s711 = new Student(711,"10:50");
        Student s811 = new Student(811,"10:52");
        Student s911 = new Student(611,"10:53");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);
        timeTable1.add(s911);





        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("2.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void Tencars2Slots12Students() {

        int totalcars= 10;
        int slotsInCar=2;

        ArrayList<Car> carsList1= new ArrayList<Car>();
        initializeCars(carsList1,totalcars,slotsInCar);

        Student s111 = new Student(111,"13:30");
        Student s211 = new Student(211,"13:31");
        Student s311 = new Student(311,"13:31");
        Student s411 = new Student(411,"13:45");
        Student s511 = new Student(511,"15:45");
        Student s611 = new Student(611,"16:01");
        Student s711 = new Student(711,"16:35");
        Student s811 = new Student(811,"16:42");
        Student s911 = new Student(911,"16:47");
        Student s1011 = new Student(1011,"18:08");
        Student s1111 = new Student(1111,"19:42");
        Student s1211 = new Student(1211,"20:22");



        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);
        timeTable1.add(s911);
        timeTable1.add(s1011);
        timeTable1.add(s1111);
        timeTable1.add(s1211);





        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("5.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }



    @Test
    public void fourcars3Slots08Students() {

        int totalcars= 4;
        int slotsInCar=3;

        ArrayList<Car> carsList1= new ArrayList<Car>();

        initializeCars(carsList1,totalcars,slotsInCar);



        Student s111 = new Student(111,"10:05");
        Student s211 = new Student(211,"10:05");
        Student s311 = new Student(311,"10:06");
        Student s411 = new Student(411,"13:01");
        Student s511 = new Student(511,"16:20");
        Student s611 = new Student(611,"16:25");
        Student s711 = new Student(711,"17:00");
        Student s811 = new Student(811,"17:45");


        ArrayList<Student> timeTable1 = new ArrayList<Student>();
        timeTable1.add(s111);
        timeTable1.add(s211);
        timeTable1.add(s311);
        timeTable1.add(s411);
        timeTable1.add(s511);
        timeTable1.add(s611);
        timeTable1.add(s711);
        timeTable1.add(s811);




        try {
            printData(timeTable1,carsList1,slotsInCar);
            assertEquals("41.0",Helper.getTotalCarCostString(carsList1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    private static void printData(ArrayList<Student> timeTable1, ArrayList<Car> carsList1,int slotsInCar)
    {
        Scheduler.optimzer(timeTable1, carsList1,slotsInCar);
        System.out.println("==============Students wait Time ============");
        for(int i=0;i< carsList1.size() ;i++)
        {

            carsList1.get(i).getCarAndPassengerDetais();

        }
        System.out.println("==============Total Wait Time for All Students ============");
        System.out.println( "Total Car wait time is ->" + Helper.getTotalCarCost(carsList1) + " mins");
        System.out.println("==============Over ========================================");


    }

    private static void initializeCars(ArrayList<Car> carsList1,int totalcars,int  slotsInCar)
    {
        for(int i=0;i< totalcars ;i++)
        {
            Car car= new Car(i,slotsInCar);
            carsList1.add(car);

        }
    }

}
