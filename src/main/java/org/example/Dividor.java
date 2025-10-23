package org.example;

public class Dividor implements ICalculator{
    @Override
    public int calc(int firstValue, int secondValue) {
        return firstValue / secondValue;
    }
}
