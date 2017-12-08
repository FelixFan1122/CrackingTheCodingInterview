package com.felix.ctci.Intersection;

import com.felix.ctci.CodeLibrary.Node;

public class Intersection {
    public static boolean hasIntersection(Node linkedList1, Node linkedList2) {
        int length1 = getLength(linkedList1);
        int length2 = getLength(linkedList2);

        Node longList;
        Node shortList;
        if (length1 < length2) {
            longList = linkedList2;
            shortList = linkedList1;
        } else {
            longList = linkedList1;
            shortList = linkedList2;
        }

        int difference = length1 < length2 ? length2 - length1 : length1 - length2;
        while (difference > 0) {
            difference--;
            longList = longList.getNext();
        }

        while (longList.getNext() != null) {
            if (longList.getData() == shortList.getData()) {
                return true;
            }

            longList = longList.getNext();
            shortList = shortList.getNext();
        }

        return false;
    }

    private static int getLength(Node linkedList) {
        if (linkedList == null) {
            return 0;
        }

        int length = 1;
        while (linkedList.getNext() != null) {
            linkedList = linkedList.getNext();
            length++;
        }

        return length;
    }
}
