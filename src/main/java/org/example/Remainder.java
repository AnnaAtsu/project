package org.example;

public class Remainder implements ICalculator{
    @Override
    public int calc(int...args) {
        return args[0] % args[1];
    }
}
