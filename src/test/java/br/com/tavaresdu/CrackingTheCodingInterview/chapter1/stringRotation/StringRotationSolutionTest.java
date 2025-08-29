package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringRotation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StringRotationSolutionTest {
    private static final List<StringRotationSolution> solutions = List.of(
            spy(StringRotationFirstSolution.class)
    );

    @BeforeAll
    static void setUp() {
        solutions.forEach(solution -> {
            when(solution.isSubstring(anyString(), anyString())).thenCallRealMethod();
            when(solution.isRotation(anyString(), anyString())).thenCallRealMethod();
        });
    }

    @ParameterizedTest
    @MethodSource("isSubstringParameters")
    void isSubstring(String inputString1, String inputString2, boolean expected, StringRotationSolution solution) {
        assertEquals(expected, solution.isSubstring(inputString1, inputString2));
    }

    @ParameterizedTest
    @MethodSource("isRotationParameters")
    void isRotation(String inputString1, String inputString2, boolean expected, StringRotationSolution solution) {
        assertEquals(expected, solution.isRotation(inputString1, inputString2));
        verify(solution).isSubstring(anyString(), anyString());
    }

    public static Stream<Arguments> isSubstringParameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("abcde", "bcd", true, impl));
            arguments.add(Arguments.of("abc", "def", false, impl));
            arguments.add(Arguments.of("abc", "a", true, impl));
            arguments.add(Arguments.of("abc", "abc", true, impl));
            arguments.add(Arguments.of("abcd", "bcde", false, impl));
        });
        return arguments.stream();
    }

    public static Stream<Arguments> isRotationParameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("waterbottle", "erbottlewat", true, impl));
            arguments.add(Arguments.of("waterbottle", "erbottle", false, impl));
        });
        return arguments.stream();
    }
}