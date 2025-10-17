package org.example.manager;

public class Main {



    /**
     * ENUM CalculateAction для действий в методе калькулятора. Есть деление, умножение, сложение, вычитание и остаток от деления.
     */
    enum CalculateAction {
        SUM, MULTIPLY, SUB, DIVIDE, REMAINDER;
    }


    public static int calculate(int firstValue, int secondValue, CalculateAction action) {
        switch (action) {
            case SUM:
                return firstValue + secondValue;
            case MULTIPLY:
                return firstValue * secondValue;
            case SUB:
                return firstValue - secondValue;
            case DIVIDE:
                if (secondValue == 0) {
                    throw new IllegalArgumentException("На ноль делить нельзя");
                }
                return firstValue / secondValue;
            case REMAINDER:
                if (secondValue == 0) {
                    throw new IllegalArgumentException("На ноль делить нельзя");
                }
                return firstValue % secondValue;
            default:
                throw new IllegalArgumentException("Калькулятор не выполняет такие вычисления: " + action);
        }
    }


    public static void main(String[] args) {

        System.out.println(calculate(10, 3, CalculateAction.DIVIDE)); // 3
    }
}

