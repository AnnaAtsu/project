package org.example;

public class Factoriator implements ICalculator{
    @Override
    public int calc(int... args) {
        if (args[0] == 0) {
            return 1;
        }
        return args[0] * calc(args[0] - 1);
    }
}
