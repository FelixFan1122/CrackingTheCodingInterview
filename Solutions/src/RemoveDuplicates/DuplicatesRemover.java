package com.felix.ctci.RemoveDuplicates;

import com.felix.ctci.CodeLibrary.Node;

import java.util.HashSet;

public class DuplicatesRemover {
    private final Node linkedList;

    public DuplicatesRemover(Node linkedList) {
        this.linkedList = linkedList;
    }

    public Node RemoveDuplicates() {
        Node current = linkedList;
        Node previous;
        HashSet<Integer> hashSet = new HashSet<>(current.getData());
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
            if (hashSet.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                hashSet.add(current.getData());
            }
        }

        return linkedList;
    }

    public Node RemoveDuplicatesSpaceConstrained() {
        Node sample = linkedList;
        while (sample.getNext() != null) {
            Node previous = sample;
            Node current = sample.getNext();
            if (current.getData() == sample.getData()) {
                previous.setNext(current.getNext());
            }

            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
                if (current.getData() == sample.getData()) {
                    previous.setNext(current.getNext());
                }
            }

            sample = sample.getNext();
        }

        return linkedList;
    }
}
