package com.company;

import java.util.List;

/**
 * Created by meghan on 4/2/2019.
 */

public interface MovingAverage {

    //method to add item in the queue
    void add(double item);

    //method to return the average of the last N elements
    double getAverageOfNLastElements() throws Exception;

    //method to return the last N elements
    List<Double> getElements();

}
