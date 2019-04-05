package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by meghan on 4/2/2019.
 */
public class MovingAverageImpl implements MovingAverage {

    int size;
    double sum;
    Queue<Double> queue;

    public MovingAverageImpl(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    @Override
    public void add(double value) {
        sum += value;
        queue.add(value);

        //check to see if the list size is greater than size
        //If there are n elements in the list and you add the (n+1) element,
        //we need to subtract the 1st element from the sum
        if(queue.size()>size) {
            sum -= queue.poll();
        }
    }

    @Override
    public double getAverageOfNLastElements() throws Exception {
        //if the list size is less than size, throw an exception
        if(queue.size() < size){
            throw new Exception();
        }
        return sum/size;
    }

    @Override
    public List<Double> getElements() {
        List<Double> listOfElements = new LinkedList<>();
        Iterator<Double> itr = queue.iterator();
        while (itr.hasNext()) {
            listOfElements.add(itr.next());
        }

        return listOfElements;
    }

}
