package org.example;

public class Remainder implements ICalculator{
    @Override
    public int calc(int firstValue, int secondValue) {
        return firstValue % secondValue;
    }
}
