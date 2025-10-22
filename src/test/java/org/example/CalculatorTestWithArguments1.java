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
                Arguments.of(2, 3, Main1.CalculateAction1.SUM, 5),
                Arguments.of(5, 4, Main1.CalculateAction1.MULTIPLY, 20),
                Arguments.of(10, 3, Main1.CalculateAction1.SUB, 7),
                Arguments.of(9, 3, Main1.CalculateAction1.DIVIDE, 3),
                Arguments.of(10, 3, Main1.CalculateAction1.REMAINDER, 1)

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
    void testCalculate(int a, int b, Main1.CalculateAction1 action, int expected) throws DivideByZero {
        int result = Main1.calculate(a, b, action);
        assertEquals(expected, result);
    }

    /**
     * Параметризированный тест проверки работы калькулятора с делением и остатком от деления 0
     * @param a int первое число
     * @param action enum вычислительное действие(здесь использовать DIVIDE или REMAINDER)
     */
    @ParameterizedTest
    @MethodSource("provideDivisionByZeroActions")
    void testDivisionByZero(int a, Main1.CalculateAction1 action) {
        DivideByZero divideByZero = assertThrows(DivideByZero.class, () -> {
            Main1.calculate(a, 0, action);
        });

        assertEquals("null", divideByZero.getMessage());
    }

    /**
     * Стрим с аргументами с тестовыми данными для проверки метода calculate для проверки на делением и остатком от деления 0
     * @return Stream
     */
    static Stream<Arguments> provideDivisionByZeroActions() {
        return Stream.of(
                Arguments.of(5, Main1.CalculateAction1.DIVIDE),
                Arguments.of(10, Main1.CalculateAction1.REMAINDER)
        );
    }
}
