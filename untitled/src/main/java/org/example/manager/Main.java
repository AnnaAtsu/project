package org.example.manager;

public class Main {



    /**
     * ENUM CalculateAction для действий в методе калькулятора. Есть деление, умножение, сложение, вычитание и остаток от деления.
     */
    public enum CalculateAction {
        SUM, MULTIPLY, SUB, DIVIDE, REMAINDER;
    }


    /**
     * Метод вычисляет деление, умножение, сложение, вычитание и остаток от деления, действие берутся из enum CalculateAction. При пробросе исключения возвращает текст ошибки и 0
     * @param firstValue
     * @param secondValue
     * @param action
     * @return
     */
    public static int calculate(int firstValue, int secondValue, CalculateAction action) {
        switch (action) {
            case SUM:
                return firstValue + secondValue;
            case MULTIPLY:
                return firstValue * secondValue;
            case SUB:
                return firstValue - secondValue;
            case DIVIDE:
                try {
                    return firstValue / secondValue;
                } catch (ArithmeticException e) {
                    System.out.println("Нельзя делить на ноль!");
                                    }
                break;
            case REMAINDER:
                try {
                    return firstValue % secondValue;
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: остаток от деления на ноль!");
                }
                break;
            default:
                System.out.println("Неизвестная операция: " + action);
                return 0;
        }

        return 0;
    }


    public static void main(String[] args) {

        System.out.println(calculate( 10, 10, CalculateAction.DIVIDE)); // 3
    }
}

