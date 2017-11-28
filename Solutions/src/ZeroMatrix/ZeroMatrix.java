package com.felix.ctci.ZeroMatrix;

public class ZeroMatrix {
    public static int[][] zeroOut(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        int[][] zeroed = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (!rows[i]) {
                for (int j = 0; j < n; j++) {
                    if (!columns[j]) {
                        zeroed[i][j] = matrix[i][j];
                    }
                }
            }
        }

        return zeroed;
    }
}
