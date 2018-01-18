package com.felix.ctci.NextNumber;

public class NextNumber {
    private int intBits = Integer.BYTES * Byte.SIZE;
    private int n;

    public NextNumber (int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
    }

    public int getNextNumber() {
        int oneCount = 0;
        int position = 0;
        while (((n & (1 << position)) == 0) && position < intBits) {
            position++;
        }

        while (((n & (1 << position)) > 0) && position < intBits) {
            position++;
            oneCount++;
        }

        if (position == intBits) {
            throw new IllegalArgumentException();
        }

        return (n & (-1 << (position + 1))) | (1 << position) | (-1 >>> (intBits - oneCount));
    }

    public int getPreviousNumber() {
        int position = 0;
        int zeroCount = 0;
        while (((n & (1 << position)) > 0) && position < intBits) {
            position++;
        }

        while (((n & (1 << position)) == 0) && position < intBits) {
            position++;
            zeroCount++;
        }

        if (position == intBits) {
            throw new IllegalArgumentException();
        }

        return (n | (1 << position) & (-1 << (position - 1))) & (-1 << zeroCount);
    }
}
