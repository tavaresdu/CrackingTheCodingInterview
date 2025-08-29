package br.com.tavaresdu.CrackingTheCodingInterview.chapter2;

import java.util.StringJoiner;

public class SinglyLinkedList {
    private Node head;

    public static class Node {
        private Node next;
        private final int value;

        public Node(int value) {
            this.value = value;
        }

        public Node next() {
            return this.next;
        }

        public int value() {
            return this.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public void add(int value) {
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public boolean remove(int value) {
        Node current = this.head;
        if (current.value == value) {
            this.head = this.head.next;
            return true;
        }
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(Node node) {
        if (node == null) throw new IllegalArgumentException("Node argument cannot be null.");
        if (node == this.head) {
            this.head = this.head.next;
            return true;
        }
        Node current = this.head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node head() {
        return this.head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;
        Node thisNode = this.head;
        Node thatNode = that.head;
        while (thisNode != null && thatNode != null) {
            if (thatNode.value != thisNode.value) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        return thisNode == thatNode;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Node current = this.head;
        while (current != null) {
            joiner.add(String.valueOf(current.value()));
            current = current.next;
        }
        return joiner.toString();
    }
}
