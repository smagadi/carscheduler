package com.scheduler.test;

import com.schedule.domain.Car;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ComparatorTest {


    @Test
    public void descendingTest() {

        ArrayList<Car> carList = new ArrayList<Car>();
        Car c1 = new Car();
        c1.setCarcost(101);
        Car c2 = new Car();
        c2.setCarcost(91);
        Car c3 = new Car();
        c3.setCarcost(500);
        Car c4 = new Car();
        c4.setCarcost(0);
        Car c5 = new Car();
        c5.setCarcost(-1);

        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);
        carList.add(c5);

        Collections.sort(carList,Car.carCostComparator);



        assertArrayEquals(Arrays.asList(500,101,91,0,-1).toArray(),carList.toArray());







    }
}
