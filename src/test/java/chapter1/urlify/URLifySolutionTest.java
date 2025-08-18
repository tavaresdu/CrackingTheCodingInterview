package chapter1.urlify;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.urlify.URLifyBruteForceSolution;
import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.urlify.URLifySolution;
import br.com.tavaresdu.CrackingTheCodingInterview.chapter1.urlify.URLifyStartingAtTheEndSolution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class URLifySolutionTest {
    private static List<URLifySolution> solutions;

    @BeforeAll
    static void setUp() {
        solutions = List.of(
                new URLifyBruteForceSolution(),
                new URLifyStartingAtTheEndSolution()
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void urlify(String text, int length, String expected, URLifySolution solution) {
        assertEquals(expected, solution.urlify(text.toCharArray(), length));
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of("Mr John Smith    ", 13, "Mr%20John%20Smith", impl));
            arguments.add(Arguments.of("   ", 1, "%20", impl));
            arguments.add(Arguments.of("abcde", 5, "abcde", impl));
            arguments.add(Arguments.of("abcde   ", 6, "abcde%20", impl));
            arguments.add(Arguments.of(" abcde  ", 6, "%20abcde", impl));
            arguments.add(Arguments.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do e" +
                    "iusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostru" +
                    "d exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor i" +
                    "n reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                    "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                    "                                                                                               " +
                    "                                         ", 445,
                    "Lorem%20ipsum%20dolor%20sit%20amet,%20consectetur%20adipiscing%20elit,%20sed%20do%20eiusmod%20t" +
                            "empor%20incididunt%20ut%20labore%20et%20dolore%20magna%20aliqua.%20Ut%20enim%20ad%20min" +
                            "im%20veniam,%20quis%20nostrud%20exercitation%20ullamco%20laboris%20nisi%20ut%20aliquip%" +
                            "20ex%20ea%20commodo%20consequat.%20Duis%20aute%20irure%20dolor%20in%20reprehenderit%20i" +
                            "n%20voluptate%20velit%20esse%20cillum%20dolore%20eu%20fugiat%20nulla%20pariatur.%20Exce" +
                            "pteur%20sint%20occaecat%20cupidatat%20non%20proident,%20sunt%20in%20culpa%20qui%20offic" +
                            "ia%20deserunt%20mollit%20anim%20id%20est%20laborum.", impl));
        });
        return arguments.stream();
    }
}

