package com.felix.ctci.Partition;

import com.felix.ctci.CodeLibrary.Node;

public class LinkedListPartition {
    public static Node partition(Node linkedList, int pivot) {
        if (linkedList == null || linkedList.getNext() == null) {
            return linkedList;
        }

        Node tail = null;
        Node current = linkedList;
        Node previous = null;
        Node head = linkedList;
        do {
            if (current.getData() >= pivot) {
                if (tail == null) {
                    tail = new Node(current.getData());
                } else {
                    tail.setNext(current);
                }

                if (previous != null) {
                    previous.setNext(current.getNext());
                }

                if (current == head) {
                    head = current.getNext();
                }
            }

            previous = current;
            current = current.getNext();
        } while (current.getNext() != null);

        current.setNext(tail);

        return head;
    }
}
