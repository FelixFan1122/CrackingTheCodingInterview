package com.felix.ctci.CountOf2s;

public class CountOf2s {
    public int count2s(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int numberOfDigits = 1;
        while (n > 9) {
            n = n / 10;
            numberOfDigits++;
        }

        int firstDigit = n;
        int count = count2sByDigits(numberOfDigits - 1);
        count *= firstDigit + 1;
        if (firstDigit > 1) {
            count += (int)Math.pow(10, numberOfDigits - 1);
        }

        return count;
    }

    private int count2sByDigits(int numberOfDigits) {
        if (numberOfDigits == 1) {
            return 1;
        }

        return count2sByDigits(numberOfDigits - 1) * 9 + (int)Math.pow(10, numberOfDigits - 1);
    }
}
