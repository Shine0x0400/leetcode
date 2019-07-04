package com.zjl.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjl
 * @date 2019-07-04
 */
public class Leet130_SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int row = board.length, col = board[0].length;
        char capture = 'O';
        char free = 'F';

        // 从边界开始感染，遇到O就变为Q
        for (int i = 0; i < col; i++) {
            freeFromPosition(board, row, col, 0, i);
            freeFromPosition(board, row, col, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            freeFromPosition(board, row, col, i, 0);
            freeFromPosition(board, row, col, i, col - 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (c == capture) {
                    board[i][j] = 'X';
                } else if (c == free) {
                    board[i][j] = capture;
                }
            }
        }

    }

    private void freeFromPosition(char[][] board, int row, int col, int rowIdx, int colIdx) {

        char capture = 'O';
        char free = 'F';

        if (board[rowIdx][colIdx] == capture) {
            board[rowIdx][colIdx] = free;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(rowIdx);
            queue.add(colIdx);

            while (!queue.isEmpty()) {
                int r = queue.remove();
                int c = queue.remove();

                // left adjacent
                if (c - 1 >= 0 && board[r][c - 1] == capture) {
                    board[r][c - 1] = free;
                    queue.add(r);
                    queue.add(c - 1);
                }

                // right adjacent
                if (c + 1 < col && board[r][c + 1] == capture) {
                    board[r][c + 1] = free;
                    queue.add(r);
                    queue.add(c + 1);
                }

                // up adjacent
                if (r - 1 >= 0 && board[r - 1][c] == capture) {
                    board[r - 1][c] = free;
                    queue.add(r - 1);
                    queue.add(c);
                }

                // down adjacent
                if (r + 1 < row && board[r + 1][c] == capture) {
                    board[r + 1][c] = free;
                    queue.add(r + 1);
                    queue.add(c);
                }

            }
        }
    }
}
