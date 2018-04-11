package com.felix.ctci.SubSort;

public class SubSort {
    public int[] getUnsortedRange(int[] unsorted) {
        if (unsorted == null || unsorted.length < 2) {
            throw new IllegalArgumentException();
        }

        int firstOutOfOrder = getFirstOutOfOrder(unsorted);
        if (firstOutOfOrder == -1) {
            return new int[] { -1, -1 }; // Array is sorted.
        }

        int lastOutOfOrder = getLastOutOfOrder(unsorted);
        if (lastOutOfOrder == -1) {
            return new int[] { -1, -1 }; // Array is sorted.
        }

        int[] minAndMaxWithinUnsorted = getMinAndMax(unsorted, firstOutOfOrder, lastOutOfOrder + 1);
        int min = minAndMaxWithinUnsorted[0];
        int max = minAndMaxWithinUnsorted[1];
        int start = getMinPosition(unsorted, firstOutOfOrder, min);
        int end = getMaxPosition(unsorted, lastOutOfOrder, max);
        return new int[] { start + 1, end - 1 };
    }

    private int getFirstOutOfOrder(int[] unsorted) {
        int i = 0;
        while (i < unsorted.length - 1 && unsorted[i] <= unsorted[i + 1]) {
            i++;
        }

        if (i == unsorted.length - 1 && unsorted[i] >= unsorted[i - 1]) {
            return -1; // Array is sorted.
        }

        return i;
    }

    private int getLastOutOfOrder(int[] unsorted) {
        int i = unsorted.length - 1;
        while (i > 0 && unsorted[i] >= unsorted[i - 1]) {
            i--;
        }

        if (i == 0 && unsorted[i] <= unsorted[i + 1]) {
            return -1; // Array is sorted.
        }

        return i;
    }

    private int[] getMinAndMax(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        return new int[] { min, max };
    }

    private int getMinPosition(int[] array, int end, int min) {
        while (array[end] > min && end > 0) {
            end--;
        }

        if (end == 0 && array[end] > min) {
            end--;
        }

        return end;
    }

    private int getMaxPosition(int[] array, int start, int max) {
        while (array[start] < max && start < array.length - 1) {
            start++;
        }

        if (start == array.length - 1 && array[start] < max) {
            start++;
        }

        return start;
    }
}
