package com.zjl.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet36_ValidSudoku {

//      // Brute Force (9 rows + 9 columns + 3 * 3 sub-boxes) * 9 items, in other words, each item is visited 3 times.
//    public boolean isValidSudoku(char[][] board) {
//
//        Set<Character> set = new HashSet<>(9);
//
//        // check each row
//        for (int i = 0; i < 9; i++) {
//            set.clear();
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.' && !set.add(board[i][j])) {
//                    return false;
//                }
//            }
//        }
//
//        // check each column
//        for (int i = 0; i < 9; i++) {
//            set.clear();
//            for (int j = 0; j < 9; j++) {
//                if (board[j][i] != '.' && !set.add(board[j][i])) {
//                    return false;
//                }
//            }
//        }
//
//        // check each sub-box, (i, j) is the top-left corner
//        for (int i = 0; i <= 6; i += 3) {
//            for (int j = 0; j <= 6; j += 3) {
//                set.clear();
//                for (int k = 0; k < 3; k++) {
//                    for (int l = 0; l < 3; l++) {
//                        if (board[i + k][j + l] != '.' && !set.add(board[i + k][j + l])) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//
//        return true;
//    }

    // 一个很机灵的答案
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'
                        && (!set.add(board[i][j] + " in row " + i)
                        || !set.add(board[i][j] + " in column " + j)
                        || !set.add(board[i][j] + " in cube " + i / 3 + "-" + j / 3))) {
                    return false;
                }
            }
        }

        return true;
    }

//    // 遍历一遍，这种思路值得学习
//    public boolean isValidSudoku(char[][] board) {
//
//        // there are 9 rows, 9 columns and 9 cubes.
//        for (int i = 0; i < 9; i++) {
//            Set<Character> rowi = new HashSet<>();
//            Set<Character> columni = new HashSet<>();
//
//            Set<Character> cubei = new HashSet<>();
//            int row = (i / 3) * 3;
//            int col = (i % 3) * 3;
//
//            // each row, column and cube has 9 items.
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.' && !rowi.add(board[i][j])) {
//                    return false;
//                }
//
//                if (board[j][i] != '.' && !columni.add(board[j][i])) {
//                    return false;
//                }
//
//                if (board[row + j / 3][col + j % 3] != '.' && !cubei.add(board[row + j / 3][col + j % 3])) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }


}
