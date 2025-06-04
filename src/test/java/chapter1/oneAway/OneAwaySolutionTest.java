package chapter1.oneAway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OneAwaySolutionTest {
    private static List<OneAwaySolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new OneAwaySinglePassSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void oneAway(String input1, String input2, boolean expected, OneAwaySolution solution) {
        assertEquals(expected, solution.oneAway(input1, input2));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("pale", "ple", true, impl));
            arguments.add(Arguments.of("pales", "pale", true, impl));
            arguments.add(Arguments.of("pale", "bale", true, impl));
            arguments.add(Arguments.of("pale", "bake", false, impl));
        });
        return arguments.stream();
    }
}