package com.felix.ctci.StringRotation;

//It was solved after having taken a peek at the hints.
public class StringRotation {
    private static boolean isRotation(String input1, String input2) {
        if (input1.isEmpty() || input2.isEmpty() || input1.length() != input2.length()) {
            return false;
        }

        return (input1 + input1).contains(input2);
    }

    public static void main(String[] args) {
        System.out.printf("Is %s a rotation of %s? %s", "waterbottle", "erbottlewat", isRotation("waterbottle", "erbottlewat"));
    }
}
