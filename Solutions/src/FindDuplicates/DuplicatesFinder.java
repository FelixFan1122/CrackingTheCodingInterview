package com.felix.ctci.FindDuplicates;

import java.util.BitSet;

public class DuplicatesFinder {
    private static final int UPPER_BOUND = 32000;

    public void findDuplicates(int[] input) {
        BitSet ints = new BitSet(UPPER_BOUND);
        for (int element :
                input) {
            if (ints.get(element)) {
                System.out.println(element);
            } else {
                ints.set(element);
            }
        }
    }
}
