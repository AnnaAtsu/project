package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTestWithArguments1 {


    /**
     * Стрим с аргументами с тестовыми данными для проверки метода calculate
     * @return Stream
     */
    static Stream<Arguments> provideTestData1() {
        return Stream.of(
                Arguments.of(2, 3, Calculator.CalculateAction1.SUM, 5),
                Arguments.of(5, 4, Calculator.CalculateAction1.MULTIPLY, 20),
                Arguments.of(10, 3, Calculator.CalculateAction1.SUB, 7),
                Arguments.of(9, 3, Calculator.CalculateAction1.DIVIDE, 3),
                Arguments.of(10, 3, Calculator.CalculateAction1.REMAINDER, 1)

        );
    }

    /**
     * Параметризированный тест проверки работы калькулятора с положительными проверками
     * @param a int первое число
     * @param b int второе число
     * @param action enum вычислительное действие
     * @param expected int ожидаемый результат от вычисления
     */
    @ParameterizedTest
    @MethodSource("provideTestData1")
    void testCalculate(int a, int b, Calculator.CalculateAction1 action, int expected) throws DivideByZero {
        int result = Calculator.calculate(a, b, action);
        assertEquals(expected, result);
    }

    /**
     * Параметризированный тест проверки работы калькулятора с делением и остатком от деления 0
     * @param a int первое число
     * @param action enum вычислительное действие(здесь использовать DIVIDE или REMAINDER)
     */
    @ParameterizedTest
    @MethodSource("provideDivisionByZeroActions")
    void testDivisionByZero(int a, Calculator.CalculateAction1 action) {
        DivideByZero divideByZero = assertThrows(DivideByZero.class, () -> {
            Calculator.calculate(a, 0, action);
        });

        assertEquals("Нельзя делить на ноль!", divideByZero.getMessage());
    }

    /**
     * Стрим с аргументами с тестовыми данными для проверки метода calculate для проверки на делением и остатком от деления 0
     * @return Stream
     */
    static Stream<Arguments> provideDivisionByZeroActions() {
        return Stream.of(
                Arguments.of(5, Calculator.CalculateAction1.DIVIDE),
                Arguments.of(10, Calculator.CalculateAction1.REMAINDER)
        );
    }
}
