package br.com.tavaresdu.CrackingTheCodingInterview.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    private static final int FIRST_VALUE = 0;
    private static final int LAST_VALUE = 10;

    @Test
    public void shouldAddFirstNodeAndMakeItHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(FIRST_VALUE);
        assertEquals(FIRST_VALUE, list.head().value());
        assertNull(list.head().next());
    }

    @Test
    public void shouldAddMultiplesNodesAndLinkThem() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = FIRST_VALUE; i <= LAST_VALUE; i++) {
            list.add(i);
        }
        SinglyLinkedList.Node currentNode = list.head();
        for (int i = FIRST_VALUE; i < LAST_VALUE; i++) {
            assertEquals(i, currentNode.value());
            currentNode = currentNode.next();
        }
        assertEquals(LAST_VALUE, currentNode.value());
        assertNull(currentNode.next());
    }

    @Test
    public void shouldRemoveHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = FIRST_VALUE; i <= LAST_VALUE; i++) {
            list.add(i);
        }
        assertEquals(FIRST_VALUE, list.head().value());
        list.remove(FIRST_VALUE);
        assertNotEquals(FIRST_VALUE, list.head().value());
    }

    @Test
    public void shouldRemoveTail() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = FIRST_VALUE; i <= LAST_VALUE; i++) {
            list.add(i);
        }
        SinglyLinkedList.Node currentNode = list.head();
        while (currentNode.next() != null) {
            currentNode = currentNode.next();
        }
        assertEquals(LAST_VALUE, currentNode.value());
        list.remove(LAST_VALUE);
        currentNode = list.head();
        while (currentNode.next() != null) {
            currentNode = currentNode.next();
        }
        assertNotEquals(LAST_VALUE, currentNode.value());
    }

    @Test
    public void shouldRemoveMiddleValue() {
        int middleValue = (LAST_VALUE - FIRST_VALUE) / 2;
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = FIRST_VALUE; i <= LAST_VALUE; i++) {
            list.add(i);
        }
        SinglyLinkedList.Node currentNode = list.head();
        for (int i = FIRST_VALUE; i < middleValue; i++) {
            currentNode = currentNode.next();
        }
        assertEquals(middleValue, currentNode.value());
        list.remove(middleValue);
        currentNode = list.head();
        while (currentNode != null) {
            assertNotEquals(middleValue, currentNode.value());
            currentNode = currentNode.next();
        }
    }
}