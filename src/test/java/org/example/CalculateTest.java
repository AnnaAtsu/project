package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculateTest {

    /**
     * Вложенный тестовый класс для создания объектов с тестовыми данными
     */
    static class TestCase {
        final int a;
        final int b;
        final Calculator.CalculateAction1 action;
        final int expected;

        /**
         * Конструктор вложенного класса TestCase
         * @param a первое число
         * @param b второе число
         * @param action вычислительное действие
         * @param expected ожидаемый результат от вычисления
         */
        TestCase(int a, int b, Calculator.CalculateAction1 action, int expected) {
            this.a = a;
            this.b = b;
            this.action = action;
            this.expected = expected;
        }
    }

    /**
     * Генератор тестовых данных на основе объекта
     * @return Stream
     */
    static Stream<TestCase> provideTestData() {
        return Stream.of(
                new TestCase(2, 3, Calculator.CalculateAction1.SUM, 5),
                new TestCase(5, 4, Calculator.CalculateAction1.MULTIPLY, 20),
                new TestCase(10, 3, Calculator.CalculateAction1.SUB, 7),
                new TestCase(9, 3, Calculator.CalculateAction1.DIVIDE, 3),
                new TestCase(10, 3, Calculator.CalculateAction1.REMAINDER, 1)
        );
    }

    /**
     * Параметризированный тест проверки работы калькулятора с положительными проверками
     * @param tc тестовый набор данных из provideTestData
     */
    @ParameterizedTest
    @MethodSource("provideTestData")
    void testCalculate(TestCase tc) throws DivideByZero {
        int result = Calculator.calculate(tc.a, tc.b, tc.action);
        assertEquals(tc.expected, result);

        // Calculator.calculate(tc.a, tc.b, new Summator());
    }

    /**
     * Тест на проверку исключения. Должен вернуть 0
     */
    @Test
    void testDivideByZeroReturnsZero() throws DivideByZero {
        int result = Calculator.calculate(10, 0, Calculator.CalculateAction1.DIVIDE);
        assertEquals(0, result);
    }

}
