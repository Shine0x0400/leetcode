package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int b = matrix.length - 1, r = matrix[0].length - 1, t = 0, l = 0;

        while (t <= b && l <= r) {
            // to right
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            if (t > b) {
                break;
            }

            // to down
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            if (l > r) {
                break;
            }

            // to left
            for (int i = r; i >= l; i--) {
                list.add(matrix[b][i]);
            }
            b--;
            if (t > b) {
                break;
            }

            // to up
            for (int i = b; i >= t; i--) {
                list.add(matrix[i][l]);
            }
            l++;
            if (l > r) {
                break;
            }
        }

        return list;

    }
}
