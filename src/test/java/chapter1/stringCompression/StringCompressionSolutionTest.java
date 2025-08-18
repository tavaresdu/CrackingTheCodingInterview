package chapter1.stringCompression;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringCompression.StringCompressionSinglePassSolution;
import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringCompression.StringCompressionSolution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionSolutionTest {
    private static List<StringCompressionSolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new StringCompressionSinglePassSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void compressString(String input, String expected, StringCompressionSolution solution) {
        assertEquals(expected, solution.compressString(input));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("aabcccccaaa", "a2b1c5a3", impl));
            arguments.add(Arguments.of("abcd", "abcd", impl));
            arguments.add(Arguments.of("aaaaaaaaaa", "a10", impl));
            arguments.add(Arguments.of("abbbbbc", "a1b5c1", impl));
            arguments.add(Arguments.of("deeeef", "deeeef", impl));
            arguments.add(Arguments.of("a", "a", impl));
            arguments.add(Arguments.of("aa", "aa", impl));
        });
        return arguments.stream();
    }
}