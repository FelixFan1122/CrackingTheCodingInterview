package com.felix.ctci.TripleStep;

public class TripleStep {
    public static int getNumberOfWays(int steps) {
        if (steps < 1) {
            throw new IllegalArgumentException();
        }

        if (steps == 1) {
            return 1;
        }

        if (steps == 2) {
            return 2;
        }

        if (steps == 3) {
            return 4;
        }

        int[] ways = new int[steps];
        ways[0] = 1;
        ways[1] = 2;
        ways[2] = 4;
        for (int i = 3; i < steps; i++) {
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }

        return ways[steps-1];
    }
}
