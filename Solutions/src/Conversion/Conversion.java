package com.felix.ctci.Conversion;

public class Conversion {
    public static int getConversionCount(int m, int n) {
        int difference = m ^ n;
        int count = 0;
        while (difference != 0) {
            if ((difference & 1) == 1) {
                count++;
            }

            difference >>>= 1;
        }

        return count;
    }
}
