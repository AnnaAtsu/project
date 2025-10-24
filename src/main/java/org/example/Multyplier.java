package org.example;

public class Multyplier implements ICalculator{
    @Override
    public int calc(int ... args) {
        int multyplier = 1;
        for(int arg: args) {
            multyplier *= arg;
        }
        return multyplier;
    }
}

