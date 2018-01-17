package com.felix.ctci.NextNumber;

public class NextNumber {
    private int n;

    public NextNumber (int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
    }

    public int getNextNumber() {
      int oneCount = 0;
      if ((n & 1) == 1) {
          oneCount++;
      }

      int i = 1;
      for (; i < Integer.BYTES * Byte.SIZE; i++) {
          if ((n & (1 << i)) == 0) {
              break;
          } else {
              oneCount++;
          }
      }

      if (i == Integer.BYTES * Byte.SIZE) {
          throw new IllegalArgumentException();
      }

      return ((-1 << (i + 1)) & n) | (1 << i) | (-1 >>> (Integer.BYTES * Byte.SIZE - oneCount));
    }

    public int getPreviousNumber() {
        int zeroCount = 0;
        if ((n & 1) == 0) {
            zeroCount++;
        }

        int i = 1;
        for (; i < Integer.BYTES * Byte.SIZE; i++) {
            if ((n & (1 << i)) == 1) {
                break;
            } else {
                zeroCount++;
            }
        }

        if (i == Integer.BYTES * Byte.SIZE) {
            throw new IllegalArgumentException();
        }

        return ((-1 >>> (Integer.BYTES * Byte.SIZE - (i + 1))) | n) & (-1 << zeroCount);
    }
}
