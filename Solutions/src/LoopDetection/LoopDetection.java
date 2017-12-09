package com.felix.ctci.LoopDetection;

import com.felix.ctci.CodeLibrary.Node;

public class LoopDetection {
    public static Node detectLoop(Node linkedList) {
        if (linkedList == null || linkedList.getNext() == null || linkedList.getNext().getNext() == null) {
            return null;
        }

        Node current = linkedList.getNext();
        Node runner = linkedList.getNext().getNext();
        while (current != runner && runner.getNext() != null && runner.getNext().getNext() != null) {
            current = current.getNext();
            runner = runner.getNext().getNext();
        }

        if (current != runner) {
            return null;
        }

        current = linkedList;
        while (current != runner) {
            current = current.getNext();
            runner = runner.getNext();
        }

        return current;
    }
}
