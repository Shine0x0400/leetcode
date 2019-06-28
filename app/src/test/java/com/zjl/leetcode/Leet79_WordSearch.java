package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    char c = board[i][j];
                    board[i][j] = ' ';
                    if (existInternal(1, word, board, i, j)) {
                        return true;
                    }
                    board[i][j] = c;
                }
            }
        }

        return false;

    }

    private boolean existInternal(int idx, String word, char[][] board, int row, int col) {
        if (idx == word.length()) {
            return true;
        }

        char c = word.charAt(idx);

        // right
        if (col < board[0].length - 1 && board[row][col + 1] == c) {
            board[row][col + 1] = ' ';
            if (existInternal(idx + 1, word, board, row, col + 1)) {
                return true;
            }
            board[row][col + 1] = c;
        }

        // left
        if (col > 0 && board[row][col - 1] == c) {
            board[row][col - 1] = ' ';
            if (existInternal(idx + 1, word, board, row, col - 1)) {
                return true;
            }
            board[row][col - 1] = c;
        }

        // down
        if (row < board.length - 1 && board[row + 1][col] == c) {
            board[row + 1][col] = ' ';
            if (existInternal(idx + 1, word, board, row + 1, col)) {
                return true;
            }
            board[row + 1][col] = c;
        }

        // up
        if (row > 0 && board[row - 1][col] == c) {
            board[row - 1][col] = ' ';
            if (existInternal(idx + 1, word, board, row - 1, col)) {
                return true;
            }
            board[row - 1][col] = c;
        }


        return false;
    }
}
