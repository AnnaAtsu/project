package org.example;

public class Subator implements ICalculator{
    @Override
    public int calc(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
}
