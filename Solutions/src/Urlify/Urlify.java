package com.felix.ctci.Urlify;

public class Urlify {
    private static final String Space = "%20";

    private static boolean isWhitespace(char character) {
        // TODO: Expand this.
        return character == ' ' || character == '\t';
    }

    public static void main(String[] args) {
        System.out.println(String.format("expected = %s, actual = %s", "Mr%20John%20Smith", urlify("Mr John Smith   ")));
    }

    private static String urlify(String input) {
        String trimmed = input.trim();
        StringBuilder urlified = new StringBuilder();
        boolean isUrlified = false;
        for (int i = 0; i < trimmed.length(); i++) {
            char character = trimmed.charAt(i);
            if (isWhitespace(character)) {
                if (isUrlified) {
                    continue;
                }

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
