package com.company;

/**
 * Created by meghan on 4/2/2019.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        MovingAverage mv = new MovingAverageImpl(3);
        mv.add(1);
        mv.add(2);
        mv.add(3);
        mv.add(4);
        mv.add(5);
        mv.add(6);
        System.out.println("Moving Average=" + mv.getAverageOfNLastElements());
    }
}
