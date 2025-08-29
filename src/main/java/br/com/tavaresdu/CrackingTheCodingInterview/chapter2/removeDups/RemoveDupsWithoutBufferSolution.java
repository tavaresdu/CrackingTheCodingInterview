package br.com.tavaresdu.CrackingTheCodingInterview.chapter2.removeDups;

import br.com.tavaresdu.CrackingTheCodingInterview.chapter2.SinglyLinkedList;

public class RemoveDupsWithoutBufferSolution implements RemoveDupsSolution {
    @Override
    public void removeDups(SinglyLinkedList list) {
        if (list.head() == null) return;
        SinglyLinkedList.Node compareNode = list.head();
        while (compareNode != null && compareNode.next() != null) {
            SinglyLinkedList.Node currentNode = compareNode;
            while (currentNode.next() != null) {
                if (compareNode.value() == currentNode.next().value()) {
                    list.remove(currentNode.next());
                } else {
                    currentNode = currentNode.next();
                }
            }
            compareNode = compareNode.next();
        }
    }
}
