package com.felix.ctci.ReturnKthToLast;

import com.felix.ctci.CodeLibrary.Node;

public class ReturnKthToLast {
    private Node linkedList;

    public ReturnKthToLast(Node linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException();
        }

        this.linkedList = linkedList;
    }

    public Node returnKthToLast(int k) {
        Node runner = linkedList;
        while (k > 0 && runner.getNext() != null) {
            runner = runner.getNext();
            k--;
        }

        if (k > 0 && runner.getNext() == null) {
            throw new IllegalArgumentException();
        }

        Node kthToRunner = linkedList;
        while (runner.getNext() != null) {
            kthToRunner = kthToRunner.getNext();
            runner = runner.getNext();
        }

        return kthToRunner;
    }
}
