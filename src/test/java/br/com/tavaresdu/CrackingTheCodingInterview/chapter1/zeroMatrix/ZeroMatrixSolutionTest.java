package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.zeroMatrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ZeroMatrixSolutionTest {
    private static List<ZeroMatrixSolution> solutions = List.of(
            new ZeroMatrixHashSetSolution(),
            new ZeroMatrixWithoutDataStructureSolution()
    );

    @ParameterizedTest
    @MethodSource("parameters")
    void zeroMatrix(int[][] inputMatrix, int[][] expectedMatrix, ZeroMatrixSolution solution) {
        solution.zeroMatrix(inputMatrix);
        assertArrayEquals(expectedMatrix, inputMatrix);
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of(new int[][]{
                    {1,1,1,1,1},
                    {1,1,1,1,1}, // No zeros.
                    {1,1,1,1,1},
                    {1,1,1,1,1}
            }, new int[][]{
                    {1,1,1,1,1},
                    {1,1,1,1,1},
                    {1,1,1,1,1},
                    {1,1,1,1,1}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,0,1,1,1},
                    {1,1,1,1,1}, // Zeros on first row and on the middle.
                    {1,1,1,0,1}, // Different rows and columns.
                    {1,1,1,1,1}
            }, new int[][]{
                    {0,0,0,0,0},
                    {1,0,1,0,1},
                    {0,0,0,0,0},
                    {1,0,1,0,1}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,1,1,1,1},
                    {1,1,1,1,1}, // Zeros on first column and in the middle.
                    {0,1,1,0,1}, // Zeros in same row.
                    {1,1,1,1,1}
            }, new int[][]{
                    {0,1,1,0,1},
                    {0,1,1,0,1},
                    {0,0,0,0,0},
                    {0,1,1,0,1}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,1,1,1,1},
                    {1,1,1,0,1}, // Zeros in middle, none in first row and first column.
                    {1,1,1,1,1}, // Zeros in same column.
                    {1,1,1,0,1}
            }, new int[][]{
                    {1,1,1,0,1},
                    {0,0,0,0,0},
                    {1,1,1,0,1},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0}, // Every cell is zero.
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0}, // Every row and column is zero, except one row
                    {1,1,1,1,1},
                    {0,0,0,0,0}
            }, new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {0,0,1,0,0},
                    {0,0,1,0,0}, // Every row and column is zero, except one column
                    {0,0,1,0,0},
                    {0,0,1,0,0}
            }, new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,0,0,0,0},
                    {1,0,0,0,0}, // Every row and column is zero, except first column
                    {1,0,0,0,0},
                    {1,0,0,0,0}
            }, new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,1,1,1,1},
                    {0,0,0,0,0}, // Every row and column is zero, except first row
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
            arguments.add(Arguments.of(new int[][]{
                    {1,1,1,1,1},
                    {1,0,0,0,0}, // Every row and column is zero, except first row and first column
                    {1,0,0,0,0},
                    {1,0,0,0,0}
            }, new int[][]{
                    {1,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}
            }, impl));
        });
        return arguments.stream();
    }
}