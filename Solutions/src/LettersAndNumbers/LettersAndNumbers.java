package com.felix.ctci.LettersAndNumbers;

import java.util.Hashtable;

public class LettersAndNumbers {
    public int[] findLongestSubArray(char[] array) {
        int delta = 0;
        Hashtable<Integer, int[]> deltaToIndices = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            char element = array[i];
            if (!Character.isLetterOrDigit(element)) {
                throw new IllegalArgumentException();
            }

            delta = Character.isDigit(element) ? delta + 1 : delta - 1;
            if (!deltaToIndices.containsKey(delta)) {
                deltaToIndices.put(delta, new int[] {i, 0});
            } else {
                deltaToIndices.get(delta)[1] = i;
            }
        }

        int maxDistance = 0;
        int[] result = null;
        for (int[] indices : deltaToIndices.values()) {
            if (indices[1] - indices[0] > maxDistance) {
                maxDistance = indices[1] - indices[0];
                result = indices;
            }
        }

        return result;
    }
}
