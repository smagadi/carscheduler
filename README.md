# Carscheduler

Problem Statement
You are assigned to schedule cars for a group of student to travel from point A to point B for a day. There are total N students, M cars, and each car can hold up to C students. You know the arrival time of each student at Point A ahead of time. Each car travels one way from A to B, and does NOT return. Assume that M*C >= N, so that you can transfer all the students to the destination. Also assume that all cars are ready for boarding at Point A, and the boarding time for the students can be ignored.

Input: N, M, C (all integers, M*C>=N)

Student Arrival Time: t1, t2, …, tn (timestamps in the format hh:mm, hh integer in between 00 and 23, mm integer in between 00 and 59)

Questions: 

  (1) How will you schedule the cars such that the longest wait time for any student is minimal

  (2) How will you schedule the cars such that the total wait time for all the students is minimal
  
  
  
  # Solve :
  
  Algorithm : I have used the Greedy and Dynamic programming Technique 
  Solved the problem using 2 cycles.I have mentioned the areas of improvements.
  
  Cycle 1 
  1.  If the number of students == number of slots do not waste time allocate every one a car

  2. else of students == cars then allocate one to each let them enjoy Time complexiety O(n)

  3. else if number of students < number of slots then we have some work to do
             1. allocate the first student to car 1
             2. pick up the second student and find where is closer , if closer to first person then put this person in car 1
             3.If closer to next person then check if how many students has to be allocated and if there are enough capacity
             4.If there then push this person to next car else push him to first car
  4. In case of last person , as there is nothing to compare allocate him to the current car else if no slots allot him to next car
  
  
  Cycle 2
  1.  Find out if there are empty cars
  
  2.  Sort the carcosts in decreasing order
  
  3.  Loop through the heavy costing cars
  4.  Move the last element of the heavy car  to empty car
  5.  Loop
        Get the next last from the to be optimized car and check if the time nears the empty car one if so move passenger to that car
        Else do not move exit the Loop
  6.  end Loop
  
  # Big O Analysis 
  
   Assumption : Timing is sorted in ascending order
        S=  Number of Students
        C=  Number of Cars
        ----------------------------------------------------------------------------------------------
        Function          |     Worst case Performance complexity  |    Worst case  Space complexity
        ----------------------------------------------------------------------------------------------

     1. optimize                    O(S)                                O(S) + O(C)
     2. optimizeOnceMore            O(C)                                O(C^2)
     3. Overall                     O(S) + O(C)                         O(C^2) + O(S)
  
  
  
  
