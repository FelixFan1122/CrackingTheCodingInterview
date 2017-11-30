package com.felix.ctci.CodeLibrary;

public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public static Node Delete(Node linkedlist, int data) {
        if (linkedlist.data == data) {
            return linkedlist.next;
        }

        Node current = linkedlist;
        Node previous = null;
        while (current.next != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current.data == data) {
            previous.next = current.next;
        }

        return linkedlist;
    }

    public void append(int data) {
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }
}
