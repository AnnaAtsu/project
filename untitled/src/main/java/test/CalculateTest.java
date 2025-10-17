package test;

import jdk.jpackage.internal.Arguments;
import org.example.manager.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class CalculateTest {

    static class TestCase {
        final int a;
        final int b;
        final Main.CalculateAction action;
        final int expected;

        TestCase(int a, int b, Main.CalculateAction action, int expected) {
            this.a = a;
            this.b = b;
            this.action = action;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestData() {
        return Stream.of(
                new TestCase(2, 3, Main.CalculateAction.SUM, 5),
                new TestCase(5, 4, Main.CalculateAction.MULTIPLY, 20),
                new TestCase(10, 3, Main.CalculateAction.SUB, 7),
                new TestCase(9, 3, Main.CalculateAction.DIVIDE, 3),
                new TestCase(10, 3, Main.CalculateAction.REMAINDER, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testCalculate(TestCase tc) {
        int result = Main.calculate(tc.a, tc.b, tc.action);
        assertEquals(tc.expected, result);
    }

    @Test
    void testDivideByZeroReturnsZero() {
        int result = Main.calculate(10, 0, Main.CalculateAction.DIVIDE);
        assertEquals(0, result);
    }

}
