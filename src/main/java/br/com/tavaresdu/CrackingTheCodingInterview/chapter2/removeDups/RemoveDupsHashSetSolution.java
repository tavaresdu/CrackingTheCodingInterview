package br.com.tavaresdu.CrackingTheCodingInterview.chapter2.removeDups;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter2.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class RemoveDupsHashSetSolution implements RemoveDupsSolution {
    @Override
    public void removeDups(SinglyLinkedList list) {
        if (list.head() == null) return;
        Set<Integer> set = new HashSet<>();
        SinglyLinkedList.Node currentNode = list.head();
        set.add(currentNode.value());
        while (currentNode.next() != null) {
            if (set.contains(currentNode.next().value())) {
                list.remove(currentNode.next());
            } else {
                set.add(currentNode.next().value());
                currentNode = currentNode.next();
            }
        }
    }
}
