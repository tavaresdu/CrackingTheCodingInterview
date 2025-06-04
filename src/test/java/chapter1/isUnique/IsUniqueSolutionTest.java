package chapter1.isUnique;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsUniqueSolutionTest {
    private static List<IsUniqueSolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new IsUniqueHashMapSolution(),
                new IsUniqueBitSetSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("isUniqueParameters")
    void isUnique(String input, boolean expected, IsUniqueSolution solution) {
        assertEquals(expected, solution.isUnique(input));
    }

    public static Stream<Arguments> isUniqueParameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("abcde", true, impl));
            arguments.add(Arguments.of("aabcde", false, impl));
            arguments.add(Arguments.of("a", true, impl));
            arguments.add(Arguments.of("", true, impl));
        });
        return arguments.stream();
    }
}