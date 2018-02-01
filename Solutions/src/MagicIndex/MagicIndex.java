package com.felix.ctci.MagicIndex;

public class MagicIndex {
    public static int getMagicIndex(int[] a) {
        return getMagicIndex(a, 0, a.length);
    }

    private static int getMagicIndex(int[] a, int start, int end) {
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) {
            return mid;
        } else if (a[mid] > mid) {
            return getMagicIndex(a, start, mid);
        } else {
            return getMagicIndex(a, mid, end);
        }
    }
}
