package com.felix.ctci.SortedMerge;

public class SortedMerge {
    public static <E extends Comparable<E>> int merge(E[] a, E[] b, int lastIndexA) {
        int current = a.length - 1;
        int lastA = lastIndexA;
        int lastB = b.length - 1;
        while (lastA >= 0 && lastB >= 0) {
            if (a[lastA].compareTo(b[lastB]) > 0) {
                a[current] = a[lastA];
                lastA--;
            } else {
                a[current] = b[lastB];
                lastB--;
            }

            current--;
        }

        if (lastA < 0) {
            while (lastB >= 0) {
                a[current] = b[lastB];
                current--;
                lastB--;
            }
        } else {
            while (lastA >= 0) {
                a[current] = a[lastA];
                current--;
                lastA--;
            }
        }

        return current+1;
    }
}