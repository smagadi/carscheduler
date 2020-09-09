package com.schedule.core;

import com.schedule.domain.Car;
import com.schedule.domain.Student;
import com.schedule.util.Helper;
import com.schedule.util.Time;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Scheduler {


public static void optimzer(ArrayList timeTable, ArrayList carList,int carSlots)
{
    try
    {
        optimize( timeTable,  carList, carSlots);
        optimizeOnceMore(carList);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

/*
`   1.Get the carcosts in decreasing order
    2.Find out if there are empty cars
    3.Loop through the heavy costing cars
     4.Move the last element to empty car
        5.Loop
        Get the next last from the to be obtimzed car and check if the time nears the empty car one if so move passenger to that car
        Else do not move exit the Loop
        6.end Loop



 */
private static void optimizeOnceMore( ArrayList carList) throws Exception {

 ArrayList<Car> emptyCars = (ArrayList)Helper.getEmptyCarList(carList);
 int emptyCarSize= emptyCars.size();
 if(emptyCarSize==0)
     return;
 else
 {
     Collections.sort(carList,Car.carCostComparator);
     int heavyCarSize=carList.size()-emptyCarSize;
     int indexOfEmptyCar= 0;
     Car emptyCar= null;

     for (int heavycars = 0; heavycars < heavyCarSize; heavycars++) {

            if(emptyCarSize==0)
                break;
            //get the empty car Object
             emptyCar = emptyCars.get(indexOfEmptyCar);
             //Get all student out of it
             Car heavyCar = (Car)carList.get(heavycars);
             ArrayList<Student> heavyCarStudents= heavyCar.getPassengerList();
             int passenderList = heavyCarStudents.size();
             Student tobeMoved = null;
             ArrayList<Student>  tobeRemoved=new ArrayList<Student>();

             for(int students=0;students<passenderList ;students++){

                 tobeMoved = heavyCarStudents.get(students);

                 //Move the first student to Empty car
                 if(students==0)
                 {
                     emptyCar.addPassengerToCar(tobeMoved);
                     tobeRemoved.add(tobeMoved);
                 }
                 else
                 {
                     if(students!= passenderList-1)//last element in the heavy car leave him there
                     {
                         long diffWithNextStudentInheavyCar= Time.getTimeDiffernce((Time)tobeMoved.getArrivalTime(),(Time)heavyCarStudents.get(students+1).getArrivalTime());
                         long diffWithFirstStudentInEmptyCar= Time.getTimeDiffernce(tobeMoved.getArrivalTime(),emptyCar.getPassengerList().get(0).getArrivalTime());

                         if(diffWithNextStudentInheavyCar> diffWithFirstStudentInEmptyCar)
                         {
                             emptyCar.addPassengerToCar(tobeMoved);
                             tobeRemoved.add(tobeMoved);
                         }
                         else
                         {

                             break;
                         }
                     }

                 }
             }
             //Remove the data from heavy car and stop processing
             for(int remove=0;remove<tobeRemoved.size();remove++)
             {
                 heavyCar.removePassengerFromCar(tobeRemoved.get(remove));
             }
             emptyCarSize=emptyCarSize-1;
             indexOfEmptyCar++;

         }




 }




}



    /*
        1. If the number of students == number of slots do not waste time .

        2. else of students == cars then allocate one to each let them enjoy Time complexiety O(n)

        3. else if number of students < number of slots then we have some work to do
             1. allocate the first student to car 1
             2. pick up the second student and find where is closer , if closer to first person then put this person in car 1
             3.If closer to next person then check if how many students has to be allocated and if there are enough capacity
             4.If there then push this person to next car else push him to first car


        */

    private static void optimize(ArrayList timeTable, ArrayList carList,int carSlots) throws Exception
    {


        int totalSlot= carSlots;
        Student previousStudent=null;
        Student currentStudent =null;
        Car currentCar=null;
        int indexofCurrentCar=0;
        int timeTableSize =timeTable.size();
        int numberOfCars= carList.size();
        
        if(timeTableSize<=numberOfCars)//All the students will be having their own cars
        {
             Helper.allocateStudentACar(timeTable,carList);
             return;
        }


        for (int tt=0;tt<timeTableSize;tt++) // Loop the Time Table
        {
            currentStudent= (Student) timeTable.get(tt);

            if (tt== 0)//First student ,there is nothing to compare
            {
                //Add the student to first car
                Car firstCar = (Car) carList.get(tt);
                firstCar.addPassengerToCar(currentStudent);
                previousStudent=currentStudent;
                currentCar=firstCar;
            }
            else//Second student onwards
            {
               //Find the time differnce between the current student to previous and next student

                Time prevTime =previousStudent.getArrivalTime();
                Time currTime = currentStudent.getArrivalTime();

                if(tt+1 < timeTable.size())// Not the last student then we can optimizie

                {
                    Time nextTime = ((Student) timeTable.get(tt+1)).getArrivalTime();

                    long diffWithPrevStudent= Time.getTimeDiffernce(prevTime,currTime);
                    long diffWithNextStudent= Time.getTimeDiffernce(currTime,nextTime);

                    if(diffWithPrevStudent<= diffWithNextStudent)
                    {
                        //Check of the current car has slots

                        if (currentCar.areSlotsRemaining()) {
                            currentCar.addPassengerToCar(currentStudent);
                        } else if (indexofCurrentCar < carList.size() - 1) {
                            //push this guy to next car
                            indexofCurrentCar++;
                            Helper.addToNextCar(indexofCurrentCar, carList, currentStudent);
                        }

                    }
                    else //ok now we can decide to push the current student in current car or next car
                    {
                        //Check if there are more slots available in further cars if not push this guy in current car

                       if(Helper.getSlotsRemaining(indexofCurrentCar+1,carList)-Helper.getStudentsTobeAllocated(tt+1,timeTable)>0
                        || ! currentCar.areSlotsRemaining()
                        )
                        {
                            //push this guy to next car
                            indexofCurrentCar++;

                             currentCar = (Car)carList.get(indexofCurrentCar);
                            currentCar.addPassengerToCar(currentStudent);
                        }
                        else
                        {
                            currentCar.addPassengerToCar(currentStudent);
                        }
                    }
                }
               else //last guy ~ //needs special handling as there are no other students after him
                {

                   // Helper.allocate(currentCar,carList,currentStudent,indexofCurrentCar);
                    if (currentCar.areSlotsRemaining()) {
                        currentCar.addPassengerToCar(currentStudent);
                    } else if (indexofCurrentCar < carList.size() - 1) {
                        //push this guy to next car
                        indexofCurrentCar++;
                        currentCar = (Car)carList.get(indexofCurrentCar);
                        currentCar.addPassengerToCar(currentStudent);

                    }


                }
                previousStudent=currentStudent;
                currentCar=(Car)carList.get(indexofCurrentCar);
            }
        }

    }



}
