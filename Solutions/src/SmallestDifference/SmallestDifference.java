package com.felix.ctci.SmallestDifference;

import java.util.Arrays;

public class SmallestDifference {
    public static int getSmallestDifference(int[] input1, int[] input2) {
        Arrays.sort(input1);
        Arrays.sort(input2);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < input1.length && j < input2.length;) {
            if (Math.abs(input1[i] - input2[j]) < smallestDifference) {
                smallestDifference = Math.abs(input1[i] - input2[j]);
            }

            if (input1[i] < input2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return smallestDifference;
    }
}
