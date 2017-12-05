package com.felix.ctci.SumLists;

import com.felix.ctci.CodeLibrary.Node;

public class SumLists {
    public static Node sum(Node left, Node right) {
        if (left == null && right == null) {
            throw new IllegalArgumentException();
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        Node head;
        int carryAhead = 0;
        if (left.getData() + right.getData() > 9) {
            head = new Node(String.valueOf(left.getData() + right.getData()).charAt(1));
            carryAhead = 1;
        } else {
            head = new Node(left.getData() + right.getData());
        }

        Node current = head;
        while (left.getNext() != null && right.getNext() != null) {
            left = left.getNext();
            right = right.getNext();
            current = current.getNext();
            if (left.getData() + right.getData() + carryAhead> 9) {
                current.setNext(new Node(String.valueOf(left.getData() + right.getData() + carryAhead).charAt(1)));
                carryAhead = 1;
            } else {
                current.setNext(new Node(left.getData() + right.getData() + carryAhead));
                carryAhead = 0;
            }
        }

        Node rest = left.getNext() == null ? right : left;
        while (rest.getNext() != null) {
            rest = rest.getNext();
            current = current.getNext();
            if (rest.getData() + carryAhead > 9) {
                current.setNext(new Node(String.valueOf(rest.getData() + carryAhead).charAt(1)));
                carryAhead = 1;
            } else {
                current.setNext(new Node(rest.getData() + carryAhead));
                carryAhead = 0;
            }
        }

        if (carryAhead == 1) {
            current = current.getNext();
            current.setNext(new Node(1));
        }

        return head;
    }
}
