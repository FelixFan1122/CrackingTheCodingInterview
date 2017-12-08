package com.felix.ctci.LoopDetection;

import com.felix.ctci.CodeLibrary.Node;

import java.util.HashSet;

public class LoopDetection {
    public static Node detectLoop(Node linkedList) {
        HashSet<Node> previousNodes = new HashSet<>();
        while (linkedList != null) {
            if (previousNodes.contains(linkedList)) {
                return linkedList;
            }

            previousNodes.add(linkedList);
            linkedList = linkedList.getNext();
        }

        return null;
    }
}
