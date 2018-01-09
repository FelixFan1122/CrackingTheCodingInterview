package com.felix.ctci.Insertion;

public class Insertion {
    public static int insert(int m, int n, int i, int j) {
        int mask = (-1 << j) & (-1 >>> (32 - i));
        int maskedN = mask & n;
        int maskedM = mask | (m << i);
        return maskedN & maskedM;
    }
}
