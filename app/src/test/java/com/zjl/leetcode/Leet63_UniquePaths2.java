package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-20
 */
public class Leet63_UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] = dp[i][j-1] + dp[i-1][j]
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }

                if (j > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }

}
