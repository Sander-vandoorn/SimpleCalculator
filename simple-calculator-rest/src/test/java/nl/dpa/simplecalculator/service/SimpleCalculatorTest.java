package nl.dpa.simplecalculator.service;

import nl.dpa.simplecalculator.model.Calculation;
import nl.dpa.simplecalculator.model.Operand;
import nl.dpa.simplecalculator.repository.CalculationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

class SimpleCalculatorTest {

    private final CalculationRepository repositoryMock = Mockito.mock(CalculationRepository.class);
    private final SimpleCalculator simpleCalculator = new SimpleCalculator(repositoryMock);

    @ParameterizedTest
    @MethodSource("addSources")
    void testAdd(int first, int second, double expected) {
        Mockito.when(repositoryMock.save(Mockito.any())).thenReturn(new Calculation(first, second, Operand.ADD));

        Double result = simpleCalculator.add(first, second);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("subtractSources")
    void testSubtract(int first, int second, double expected) {
        Mockito.when(repositoryMock.save(Mockito.any())).thenReturn(new Calculation(first, second, Operand.SUBTRACT));

        Double result = simpleCalculator.subtract(first, second);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("multiplySources")
    void testMultiply(int first, int second, double expected) {
        Mockito.when(repositoryMock.save(Mockito.any())).thenReturn(new Calculation(first, second, Operand.MULTIPLY));

        Double result = simpleCalculator.multiply(first, second);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("divideSources")
    void testDivide(int first, int second, double expected) {
        Mockito.when(repositoryMock.save(Mockito.any())).thenReturn(new Calculation(first, second, Operand.DIVIDE));

        Double result = simpleCalculator.divide(first, second);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> addSources() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 4, 6),
                Arguments.of(4, 4, 8),
                Arguments.of(-4, 4, 0),
                Arguments.of(12, 20418, 20430)
        );
    }

    private static Stream<Arguments> subtractSources() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(4, 2, 2),
                Arguments.of(4, 4, 0),
                Arguments.of(-4, 4, -8),
                Arguments.of(4, -4, 8),
                Arguments.of(20418, 12, 20406)
        );
    }

    private static Stream<Arguments> multiplySources() {
        return Stream.of(
                Arguments.of(2, 1, 2),
                Arguments.of(4, 2, 8),
                Arguments.of(4, 4, 16),
                Arguments.of(-4, 4, -16),
                Arguments.of(20418, 12, 245016)
        );
    }

    private static Stream<Arguments> divideSources() {
        return Stream.of(
                Arguments.of(2, 1, 2),
                Arguments.of(4, 2, 2),
                Arguments.of(4, 4, 1),
                Arguments.of(20418, 12, 1701.5)
        );
    }
}