package com.felix.ctci.DivingBoard;

import java.util.ArrayList;

public class DivingBoard {
    private final int longer;
    private final int shorter;

    public DivingBoard(int length1, int length2) {
        if (length1 <= 0 || length2 <= 0) {
            throw new IllegalArgumentException();
        }

        longer = length1 < length2 ? length2 : length1;
        shorter = length1 < length2 ? length1 : length2;
    }

    public ArrayList<Integer> getAllPossibleLengths(int numberOfPlanks) {
        int shortest = shorter * numberOfPlanks;
        ArrayList<Integer> allPossibleLengths = new ArrayList<>();
        allPossibleLengths.add(shortest);
        int delta = longer - shorter;
        for (int i = 1; i <= numberOfPlanks; i++) {
            allPossibleLengths.add(shortest + delta * i);
        }

        return allPossibleLengths;
    }
}
