package org.example;

import static java.lang.Math.round;

public class Logarifmator implements ICalculator{
    @Override
    public int calc(int... args) {
        return (int) Math.round((Math.log(args[0]) / Math.log(args[1])));
    }
}
