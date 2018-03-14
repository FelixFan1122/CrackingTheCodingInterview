package com.felix.ctci.CodeLibrary;

public class BitSet {
    private static final int INT_SIZE = Integer.BYTES * Byte.SIZE;

    private int[] backingStorage;

    public BitSet(int size) {
        backingStorage = new int[size / INT_SIZE + 1];
    }

    public boolean get(int position) {
        return ((1 << (position % INT_SIZE)) & backingStorage[position / INT_SIZE]) != 0;
    }

    public void set(int position) {
        backingStorage[position / INT_SIZE] |= 1 << (position % INT_SIZE);
    }
}
