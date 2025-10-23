package org.example;

import static java.lang.Math.round;

public class Logarifmator implements ICalculator{
    @Override
    public int calc(int firstValue, int secondValue) {
        return (int) Math.round((Math.log(firstValue) / Math.log(secondValue)));
    }
}
