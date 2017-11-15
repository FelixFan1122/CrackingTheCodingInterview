package com.felix.ctci.IsUnique;

import java.util.BitSet;

public class IsUnique {
    public static boolean IsUnique(String text) {
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
}