package com.felix.ctci.StringCompression;

import java.io.IOException;

public class CharacterCountStringCompressor {
    private final String original;

    public CharacterCountStringCompressor(String toBeCompressed) {
        original = toBeCompressed;
    }

    public String compress() {
        char[] characters = original.toCharArray();
        int count = 1;
        char current = characters[0];
        StringBuilder compressed = new StringBuilder();
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == current) {
                count++;
            } else {
                compressed.append(current);
                compressed.append(count);
                current = characters[i];
                count = 1;
            }
        }

        compressed.append(current);
        compressed.append(count);

        return compressed.length() > original.length() ? original : compressed.toString();
    }

    public static void main(String[] args) {
        System.out.println("Please type in a string containing only alphabets.");
        try {
            byte[] input = System.in.readAllBytes();
            CharacterCountStringCompressor compressor = new CharacterCountStringCompressor(new String(input));
            String compressed = compressor.compress();
            System.out.printf("Our algorithm compress it into %s", compressed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
