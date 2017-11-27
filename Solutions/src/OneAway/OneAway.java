package com.felix.ctci.OneAway;

public class OneAway {
    private static boolean isOneAway(String input1, String input2) {
        String longer;
        String shorter;
        if (input1.length() > input2.length()) {
            longer = input1;
            shorter = input2;
        } else {
            longer = input2;
            shorter = input1;
        }

        int lengthDifference = longer.length() - shorter.length();

        switch (longer.length() - shorter.length()) {
            case 0:
                return isOneEditAway(longer, shorter);
            case 1:
                return isOneInsertAway(longer, shorter);
            default:
                return false;
        }
    }

    private static boolean isOneEditAway(String longer, String shorter) {
        int count = 0;
        for (int i = 0; i < longer.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }

    private static boolean isOneInsertAway(String longer, String shorter) {
        int count = 0;
        for (int i = 0, j = 0; i < shorter.length(); i++, j++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                count++;
                if (count > 1) {
                    return false;
                }

                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(String.format("input1 = %s, input2 = %s, returns %s", "One", "Once", OneAway.isOneAway("One", "Once")));
        System.out.println(String.format("input1 = %s, input2 = %s, returns %s", "Ouce", "Once", OneAway.isOneAway("Ouce", "Once")));
        System.out.println(String.format("input1 = %s, input2 = %s, returns %s", "Ouue", "Once", OneAway.isOneAway("Ouue", "Once")));
    }
}
