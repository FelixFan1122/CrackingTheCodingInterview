package com.felix.ctci;

import com.felix.ctci.IsUnique.IsUnique;

public class Console {
    public static void main(String[] args) {
        boolean expected = false;
        boolean actual = IsUnique.IsUnique("I'm not unique!");
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
        expected = true;
        actual = IsUnique.IsUnique("Unique!");
        System.out.println(String.format("expected = %s, actual = %s", expected, actual));
    }
}
