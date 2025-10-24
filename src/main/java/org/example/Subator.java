package org.example;

public class Subator implements ICalculator{
    @Override
    public int calc(int... args) {
       int sub = args[0];
       for(int i = 1; i < args.length; i++) {
           sub -= args[i];
       }
       return sub;
    }
}
