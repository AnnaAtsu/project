package org.example;

public class Summator implements ICalculator {


    @Override
    public int calc(int... args) {
        int summa = 0;
        for (int arg : args) {
            summa += arg;
        }
        return summa;
    }
}
