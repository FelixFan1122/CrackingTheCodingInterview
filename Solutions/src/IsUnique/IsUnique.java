package com.felix.ctci.IsUnique;

import java.util.HashSet;

public class IsUnique {
    public static boolean IsUnique(String text) {
       char[] characters = text.toCharArray();
       HashSet<Character> set = new HashSet<>();
       for (char character : characters) {
            if (set.contains(character)) {
                return false;
            }
            else {
                set.add(character);
            }
       }

       return true;
    }
}