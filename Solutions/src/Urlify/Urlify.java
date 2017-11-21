package com.felix.ctci.Urlify;

public class Urlify {
    private static final String Space = "%20";

    public static void main(String[] args) {
        System.out.println(String.format("expected = %s, actual = %s", "Mr%20John%20Smith", urlify("Mr John Smith   ")));
    }

    private static String urlify(String input) {
        String trimmed = input.trim();
        StringBuilder urlified = new StringBuilder();
        boolean isUrlified = false;
        for (int i = 0; i < trimmed.length(); i++) {
            char character = trimmed.charAt(i);
            if (character == ' ' && !isUrlified) {
                urlified.append(Space);
                isUrlified = true;
            } else {
                urlified.append(character);
                isUrlified = false;
            }
        }

        return urlified.toString();
    }
}
