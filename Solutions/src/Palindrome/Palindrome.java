package com.felix.ctci.Palindrome;

import com.felix.ctci.CodeLibrary.Node;

public class Palindrome {
    public static boolean isPalindrome(Node linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException();
        }

        Node current = linkedList;
        Node reverse = linkedList;
        int length = 1;
        while (current.getNext() != null) {
            current = current.getNext();
            Node clone = new Node(current.getData());
            clone.setNext(reverse);
            reverse = clone;
            length++;
        }

        current = linkedList;
        for (int i = 0; i < length / 2; i++) {
            if (reverse.getData() != current.getData()) {
                return false;
            }

            current = current.getNext();
            reverse = reverse.getNext();
        }

        return true;
    }
}
