package com.felix.ctci.PairwiseSwap;

public class PairwiseSwap {
    public static int swapPairwise(int n) {
        int oddMask = 0b01010101010101010101010101010101;
        int evenMask = oddMask << 1;
        int oddBits = n & oddMask;
        int evenBits = n & evenMask;
        return (oddBits << 1) | (evenBits >>> 1);
    }
}
