package com.felix.ctci.FlipBitToWin;

public class FlipBitToWin {
    public static int getLongestSequence(int n) {
        int currentRun = 0;
        boolean isFirstZero = true;
        int lastSequenceLength = 0;
        int maxSequenceLength = 0;
        for (int i = 1; i != 0; i = i << 1) {
            int digit = (n & i) == 0 ? 0 : 1;
            if (digit == 0) {
                if (isFirstZero) {
                    if (lastSequenceLength + currentRun + 1 > maxSequenceLength) {
                        maxSequenceLength = lastSequenceLength + currentRun + 1;
                    }

                    lastSequenceLength = currentRun;
                } else {
                    lastSequenceLength = 0;
                }

                isFirstZero = false;
                currentRun = 0;
            } else {
                if (isFirstZero) {
                    isFirstZero = true;
                }

                currentRun++;
            }
        }

        return maxSequenceLength;
    }
}

