package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet48_RotateImage {

    public void rotate(int[][] matrix) {
        int lastIndex = matrix.length - 1;
        int t = 0, l = 0, b = lastIndex, r = lastIndex;

        while (t < b && l < r) {
            for (int i = l; i < r; i++) {
                int tmp = matrix[t][i];
                matrix[t][i] = matrix[lastIndex - i][l];
                matrix[lastIndex - i][l] = matrix[b][lastIndex - i];
                matrix[b][lastIndex - i] = matrix[i][r];
                matrix[i][r] = tmp;
            }
            t++;
            l++;
            b--;
            r--;
        }
    }
}
