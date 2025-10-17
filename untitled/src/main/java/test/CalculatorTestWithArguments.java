package test;

import org.example.manager.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTestWithArguments {


    static Stream<Arguments> provideTestData1() {
        return Stream.of(
                Arguments.of(2, 3, Main.CalculateAction.SUM, 5),
                Arguments.of(5, 4, Main.CalculateAction.MULTIPLY, 20),
                Arguments.of(10, 3, Main.CalculateAction.SUB, 7),
                Arguments.of(9, 3, Main.CalculateAction.DIVIDE, 3),
                Arguments.of(10, 3, Main.CalculateAction.REMAINDER, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData1")
    void testCalculate(int a, int b, Main.CalculateAction action, int expected) {
        int result = Main.calculate(a, b, action);
        assertEquals(expected, result);
    }

    // Отдельный тест для деления на ноль
    @ParameterizedTest
    @MethodSource("provideDivisionByZeroActions")
    void testDivisionByZero(int a, Main.CalculateAction action) {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.calculate(a, 0, action);
        });
    }

    static Stream<Arguments> provideDivisionByZeroActions() {
        return Stream.of(
                Arguments.of(5, Main.CalculateAction.DIVIDE),
                Arguments.of(10, Main.CalculateAction.REMAINDER)
        );
    }
}
