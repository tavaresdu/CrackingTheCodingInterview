package chapter1.palindromePermutation;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.palindromePermutation.PalindromePermutationBitSetSolution;
import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.palindromePermutation.PalindromePermutationHashMapSolution;
import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.palindromePermutation.PalindromePermutationSolution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationSolutionTest {
    private static List<PalindromePermutationSolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new PalindromePermutationHashMapSolution(),
                new PalindromePermutationBitSetSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPalindromePermutation(String text, boolean expected, PalindromePermutationSolution solution) {
        assertEquals(expected, solution.isPalindromePermutation(text));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("tact coa", true, impl));
            arguments.add(Arguments.of("t", true, impl));
            arguments.add(Arguments.of("aaaaaaaaaaaaaa", true, impl));
            arguments.add(Arguments.of("abcdabcd", true, impl));
            arguments.add(Arguments.of("abcdabcde", true, impl));
            arguments.add(Arguments.of("abcdabcdef", false, impl));
            arguments.add(Arguments.of("wrong", false, impl));
        });
        return arguments.stream();
    }
}