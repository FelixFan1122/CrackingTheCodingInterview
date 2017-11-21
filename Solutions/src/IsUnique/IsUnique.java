package com.felix.ctci.IsUnique;

import java.util.BitSet;

public class IsUnique {
    private static boolean IsUnique(String text) {
       char[] characters = text.toCharArray();
       BitSet set = new BitSet();
       for (char character : characters) {
           int index = (int)character;
           if (set.get(index)) {
                return false;
            }
            else {
                set.flip(index);
            }
       }

       return true;
    }

    public static void main(String[] args) {
        boolean expected = false;
        boolean actual = IsUnique.IsUnique("I'm not unique!");
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
        expected = true;
        actual = IsUnique.IsUnique("Unique!");
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
    }
}