package com.felix.ctci.Intersection;

import com.felix.ctci.CodeLibrary.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {
    public static boolean hasIntersection(Node linkedList1, Node linkedList2) {
        if (linkedList1 == null || linkedList2 == null) {
            return false;
        }

        HashMap<Node, ArrayList<Node>> nodes = new HashMap<>();
        while (linkedList1.getNext() != null) {
            if (nodes.containsKey(linkedList1)) {
                nodes.get(linkedList1).add(linkedList1);
            } else {
                ArrayList<Node> list = new ArrayList<>();
                list.add(linkedList1);
                nodes.put(linkedList1, list);
            }

            linkedList1 = linkedList1.getNext();
        }

        while (linkedList2.getNext() != null) {
            if (nodes.containsKey(linkedList2)) {
                if (nodes.get(linkedList2).contains(linkedList2)) {
                    return true;
                }
            }

            linkedList2 = linkedList2.getNext();
        }

        return false;
    }
}
