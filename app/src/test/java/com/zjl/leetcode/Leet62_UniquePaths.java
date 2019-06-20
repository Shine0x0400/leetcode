package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-20
 */
public class Leet62_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // dp[i][j] = dp[i][j-1] + dp[i-1][j]
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
