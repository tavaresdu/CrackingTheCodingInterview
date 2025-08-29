package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.rotateMatrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateMatrixSolutionTest {
    private static final List<RotateMatrixSolution> solutions = List.of(
            new RotateMatrixNewMatrixSolution(),
            new RotateMatrixSameMatrixSolution()
    );

    @ParameterizedTest
    @MethodSource("parameters")
    void rotateMatrix(int[][] input, int[][] expected, RotateMatrixSolution solution) {
        assertEquals(expected, solution.rotateMatrix(input));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of(List.of(), null, impl));
            arguments.add(Arguments.of(List.of(List.of()), null, impl));
            arguments.add(Arguments.of(generateInputMatrix(1), generateExpectedMatrix(1), impl));
            arguments.add(Arguments.of(generateInputMatrix(2), generateExpectedMatrix(2), impl));
            arguments.add(Arguments.of(generateInputMatrix(3), generateExpectedMatrix(3), impl));
            arguments.add(Arguments.of(generateInputMatrix(4), generateExpectedMatrix(4), impl));
            arguments.add(Arguments.of(generateInputMatrix(5), generateExpectedMatrix(5), impl));
            arguments.add(Arguments.of(generateInputMatrix(6), generateExpectedMatrix(6), impl));
            arguments.add(Arguments.of(generateInputMatrix(250), generateExpectedMatrix(250), impl));
        });
        return arguments.stream();
    }

    private static int[][] generateInputMatrix(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = number++;
            }
        }
        return matrix;
    }

    private static int[][] generateExpectedMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (size-i) + (size*j);
            }
        }
        return matrix;
    }
}