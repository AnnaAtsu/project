package org.example;

public class Main1 {
    /**
     * ENUM CalculateAction для действий в методе калькулятора. Есть деление, умножение, сложение, вычитание и остаток от деления.
     */
    public enum CalculateAction1 {
        SUM, MULTIPLY, SUB, DIVIDE, REMAINDER;
    }


    /**
     * Метод вычисляет деление, умножение, сложение, вычитание и остаток от деления, действие берутся из enum CalculateAction. При пробросе исключения возвращает текст ошибки и 0
     * @param firstValue int первое число
     * @param secondValue int второе число
     * @param action enum вычислительное действие
     * @return int
     */
    public static int calculate(int firstValue, int secondValue, CalculateAction1 action) throws DivideByZero {
        switch (action) {
            case SUM:
                return firstValue + secondValue;
            case MULTIPLY:
                return firstValue * secondValue;
            case SUB:
                return firstValue - secondValue;
            case DIVIDE:
                if (secondValue == 0) {
                    throw new DivideByZero("Нельзя делить на ноль!");
                }
                return firstValue / secondValue;
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


    public static void main(String[] args) throws DivideByZero {

        System.out.println(calculate( 10, 10, CalculateAction1.DIVIDE)); // 3
    }

}
