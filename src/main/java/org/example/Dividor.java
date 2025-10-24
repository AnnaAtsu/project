package org.example;

public class Dividor implements ICalculator{
    @Override
    public int calc(int...args) {
        return args[0]/args[1];
    }
}
