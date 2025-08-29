package br.com.tavaresdu.CrackingTheCodingInterview.chapter2.removeDups;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter2.SinglyLinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDupsSolutionTest {
    private static final List<RemoveDupsSolution> solutions = List.of(
            new RemoveDupsHashSetSolution(),
            new RemoveDupsWithoutBufferSolution()
    );

    @ParameterizedTest
    @MethodSource("parameters")
    void removeDups(SinglyLinkedList inputList, SinglyLinkedList expectedList, RemoveDupsSolution solution) {
        solution.removeDups(inputList);
        assertEquals(expectedList, inputList);
    }

    public static Stream<Arguments> parameters() {
        List<Arguments> arguments = new LinkedList<>();
        solutions.forEach(impl -> {
            arguments.add(Arguments.of(linkedListOf(1,2,1,2,3,4,2,4,5,2), linkedListOf(1,2,3,4,5), impl));
            arguments.add(Arguments.of(linkedListOf(0,0,0,0,0,0,0,0,0,0), linkedListOf(0), impl));
            arguments.add(Arguments.of(linkedListOf(), linkedListOf(), impl));
        });
        return arguments.stream();
    }

    private static SinglyLinkedList linkedListOf(int... args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int arg : args) {
            list.add(arg);
        }
        return list;
    }
}