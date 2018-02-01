package com.felix.ctci.MagicIndex;

public class MagicIndex {
    public static int getMagicIndex(int[] a) {
        return getMagicIndex(a, 0, a.length - 1);
    }

    private static int getMagicIndex(int[] a, int start, int end) {
        if (start < end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        }

        int left = getMagicIndex(a, start, mid - 1);
        if (left >= 0) {
            return left;
        }

        int right = getMagicIndex(a, mid + 1, end);
        if (right >= 0) {
            return right;
        }

        return -1;
    }
}
