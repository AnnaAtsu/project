package org.example;

public class Summator implements ICalculator{

    /**
     * Переопределенный метод для подсчета суммы из интерфейса ICalculator
     * @param firstValue int
     * @param secondValue int
     * @return сумму чисел int
     */
    @Override
    public int calc(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }
}
