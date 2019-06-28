package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet73_SetMatrixZeroes {

    // O(1) space
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;

        // because (0,0) can not represent row and column at the same time, here use it represent first column only,
        // and introduce a boolean represent first row.
        boolean firstRowEmpty = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    if (i != 0) {
                        matrix[i][0] = 0;
                    } else {
                        firstRowEmpty = true;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // first column is empty
        if (matrix[0][0] == 0) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowEmpty) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }

//    // O(m + n) space
//    public void setZeroes(int[][] matrix) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return;
//        }
//
//        int m = matrix.length, n = matrix[0].length;
//        boolean[] emptyRow = new boolean[m];
//        boolean[] emptyCol = new boolean[n];
//        Arrays.fill(emptyRow, false);
//        Arrays.fill(emptyCol, false);
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    emptyRow[i] = true;
//                    emptyCol[j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            if (emptyRow[i]) {
//                for (int j = 0; j < n; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (emptyCol[i]) {
//                for (int j = 0; j < m; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }
//
//    }
}
