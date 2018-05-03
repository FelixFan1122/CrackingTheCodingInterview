package com.felix.ctci.WordDistance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class WordDistance {
    private HashMap<String, LinkedList<Integer>> wordToIndices;
    public WordDistance(Iterable<String> text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }

        wordToIndices = buildWordToIndices(text);
    }

    public int getDistance(String word1, String word2) {
        if (!wordToIndices.containsKey(word1) || !wordToIndices.containsKey(word2)) {
            return -1;
        }

        Iterable<Integer> indices1 = wordToIndices.get(word1);
        Iterable<Integer> indices2 = wordToIndices.get(word2);
        if (indices1 == null || indices2 == null) {
            return -1;
        }

        return getNearestDistance(indices1, indices2);
    }

    private HashMap<String, LinkedList<Integer>> buildWordToIndices(Iterable<String> text) {
        HashMap<String, LinkedList<Integer>> map = new HashMap<>();
        int index = 0;
        for (String word : text) {
            map.putIfAbsent(word, new LinkedList<>());
            map.get(word).add(index);
            index++;
        }

        return map;
    }

    private int getNearestDistance(Iterable<Integer> integers1, Iterable<Integer> integers2) {
        Iterator<Integer> iterator1 = integers1.iterator();
        Iterator<Integer> iterator2 = integers2.iterator();
        if (!iterator1.hasNext() || !iterator2.hasNext()) {
            return Integer.MAX_VALUE;
        }

        int int1 = iterator1.next();
        int int2 = iterator2.next();
        int min = Integer.MAX_VALUE;
        while (true) {
            if (int1 < int2) {
                if (min > int2 - int1) {
                    min = int2 - int1;
                }

                if (!iterator1.hasNext()) {
                    break;
                }

                int1 = iterator1.next();
            } else {
                if (min > int1 - int2) {
                    min = int1 - int2;
                }

                if (!iterator2.hasNext()) {
                    break;
                }

                int2 = iterator2.next();
            }
        }

        return min;
    }
}
