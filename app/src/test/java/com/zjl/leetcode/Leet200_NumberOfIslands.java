package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-17
 */
public class Leet200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int row = grid.length;
        if (row == 0) {
            return 0;
        }

        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    visitFromPosition(grid, row, col, i, j);
                }
            }
        }

        return ans;

    }

    // Depth-first Search
    private void visitFromPosition(char[][] grid, int row, int col, int rIdx, int cIdx) {
        char island = '1';
        if (grid[rIdx][cIdx] != island) {
            return;
        }

        grid[rIdx][cIdx] = '2';

        // left
        if (cIdx > 0 && grid[rIdx][cIdx - 1] == island) {
            visitFromPosition(grid, row, col, rIdx, cIdx - 1);
        }

        // up
        if (rIdx > 0 && grid[rIdx - 1][cIdx] == island) {
            visitFromPosition(grid, row, col, rIdx - 1, cIdx);
        }

        // right
        if (cIdx < col - 1 && grid[rIdx][cIdx + 1] == island) {
            visitFromPosition(grid, row, col, rIdx, cIdx + 1);
        }

        // down
        if (rIdx < row - 1 && grid[rIdx + 1][cIdx] == island) {
            visitFromPosition(grid, row, col, rIdx + 1, cIdx);
        }

    }
}
