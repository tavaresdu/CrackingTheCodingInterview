package chapter1.checkPermutation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckPermutationSolutionTest {
    private static List<CheckPermutationSolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new CheckPermutationHashMapSolution(),
                new CheckPermutationSoloHashMapSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void checkPermutation(String str1, String str2, boolean expected, CheckPermutationSolution solution) {
        assertEquals(expected, solution.checkPermutation(str1, str2));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("abcde", "baced", true, impl));
            arguments.add(Arguments.of("abcde", "debac", true, impl));
            arguments.add(Arguments.of("abcde", "ziggy", false, impl));
            arguments.add(Arguments.of("abcde", "abcdee", false, impl));
            arguments.add(Arguments.of("abcde", "", false, impl));
        });
        return arguments.stream();
    }
}