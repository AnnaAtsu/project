package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateWithInterfaceTest {
    /**
     * Стрим с аргументами с тестовыми данными для проверки метода calculate
     * @return Stream
     */
    static Stream<Arguments> provideTestData1() {
        return Stream.of(
                Arguments.of(2, 3, new Summator(), 5),
                Arguments.of(5, 4, new Multyplier(), 20),
                Arguments.of(10, 3, new Subator(), 7),
                Arguments.of(9, 3, new Dividor(), 3),
                Arguments.of(10, 3, new Remainder(), 1),
                Arguments.of(4,2, new Logarifmator(), 2)

        );
    }


    /**
     * Параметризированный тест проверки работы калькулятора с положительными проверками
     * @param a int первое число
     * @param b int второе число
     * @param calculator enum вычислительное действие
     * @param expected int ожидаемый результат от вычисления
     */
    @ParameterizedTest
    @MethodSource("provideTestData1")
    void testCalculate(int a, int b, ICalculator calculator, int expected) throws DivideByZero {
        int result = calculator.calc(a, b);
        assertEquals(expected, result);
    }
}
