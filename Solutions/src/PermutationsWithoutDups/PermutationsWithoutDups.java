package com.felix.ctci.PermutationsWithoutDups;

import java.util.ArrayList;

public class PermutationsWithoutDups {
    public static ArrayList<String> getPermutations(String original) {
        ArrayList<String> permutations = new ArrayList<>();
        if (original.length() == 1) {
            permutations.add(original);
            return permutations;
        }

        char firstCharacter = original.charAt(0);
        for (String permutation :
                getPermutations(original.substring(1))) {
            permutations.addAll(insertToPermutation(firstCharacter, permutation));
        }

        return permutations;
    }

    private static ArrayList<String> insertToPermutation(char character, String permutation) {
        char[] permutationCharacters = permutation.toCharArray();
        char[] insertedCharacters = new char[permutationCharacters.length + 1];
        insertedCharacters[insertedCharacters.length - 1] = character;
        ArrayList<String> inserted = new ArrayList<>();
        inserted.add(new String(insertedCharacters));
        for (int i = insertedCharacters.length - 1; i > 0; i--) {
            insertedCharacters[i] = insertedCharacters[i-1];
            insertedCharacters[i-1] = character;
            inserted.add(new String(insertedCharacters));
        }

        return inserted;
    }
}
