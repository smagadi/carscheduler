package com.schedule.util;

import com.schedule.domain.Car;
import com.schedule.domain.Student;

import java.util.*;

public class Helper {
    public static int getSlotsRemaining(int currentCar, ArrayList carList)
    {
        int carSlots=0;
        for(int i=0;i<carList.size();i++)
        {
            if(i<=currentCar-1)
                continue;
            else
            {
                Car car =(Car)carList.get(i);
                carSlots+=car.slotsRemaining();
            }
        }
        return carSlots;
    }
    public static int getStudentsTobeAllocated(int currentStudent,ArrayList timeTable)
    {
        return timeTable.size()-currentStudent;
    }
    public static float getTotalCarCost(ArrayList carList)
    {
        long allCarCost=0;
        for(int i =0 ;i< carList.size();i++)
        {
            Car car= (Car)carList.get(i);
            if(car.getCarcost()== -1)
                continue;
            else
             allCarCost+=car.getCarcost();
        }
        return allCarCost;
    }
    public static String getTotalCarCostString(ArrayList carList)
    {
        return new String(String.valueOf(getTotalCarCost(carList)));
    }

    public static void getCostlyCars(ArrayList carList)
    {
        Collections.sort(carList);

        for(Object str: carList){
            System.out.println(str);}
    }
    public static ArrayList<Car> getEmptyCarList(ArrayList carList)
    {
        ArrayList<Car> emptyCarsList = new ArrayList<Car>();
        for(int i=0;i<carList.size();i++)
        {
            Car car = (Car)carList.get(i);
            if(car.isEmpty())
                emptyCarsList.add(car);
        }
        return emptyCarsList;
    }
    public static ArrayList<Car> cloneCarsList(ArrayList<Car> carList) {

        ArrayList<Car> carListClone = new ArrayList<>();
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            Car newCar = new Car(car.getCarId(), car.getTotalCapacity());
            Iterator<Student> oldStudent = car.getPassengerList().iterator();
            while (oldStudent.hasNext()) {
                Student newStudent = new Student(oldStudent.next().getStudentId(), oldStudent.next().getArrivalTimeAsString());
                newCar.addPassengerToCar(newStudent);
            }
            carListClone.add(newCar);
        }
        return carListClone;
    }
    public static   void allocateStudentACar(ArrayList timeTable, ArrayList carList)
    {
        int timeTableSize= timeTable.size();
        for(int students= 0;students<timeTableSize;students++)
        {
            ((Car)carList.get(students)).addPassengerToCar((Student)timeTable.get(students));
        }
        return;
    }
    public static void addToNextCar(int indexofCurrentCar, ArrayList carList , Student currentStudent )
    {
        Car currentCar = (Car)carList.get(indexofCurrentCar);
        currentCar.addPassengerToCar(currentStudent);
     }
}
