package com.felix.ctci.CheckPermutation;

import java.util.List;

public class CheckPermutation {
    private static final int CodePageNumber = 128;

    private static boolean IsPermutation(List<String> inputs) {
        if (inputs.size() < 2) {
            return false;
        }

        int[] dictionary = BuildDictionary(inputs.get(0));
        for (String input :
                inputs.subList(1, inputs.size())) {
            int[] counts = dictionary.clone();
            for (int i = 0; i < input.length(); i++) {
                char codePage = input.charAt(i);
                counts[codePage]--;
                if (counts[codePage] < 0) {
                    return false;
                }
            }

            for (int count : counts) {
                if (count > 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean expected = true;
        boolean actual = IsPermutation(List.of("abcdefg", "gfedcba"));
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
        expected = false;
        actual = IsPermutation(List.of("abcdefg", "abcdeff"));
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
    }

    private static int[] BuildDictionary(String sample) {
        int[] dictionary = new int[CodePageNumber];
        for (int i = 0; i < sample.length(); i++) {
            char codePage = sample.charAt(i);
            dictionary[codePage]++;
        }

        return dictionary;
    }
}
