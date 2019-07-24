package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-07-24
 */
public class Leet212_WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<Integer>[] position = new List[26];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int idx = board[i][j] - 'a';
                if (position[idx] == null) {
                    position[idx] = new ArrayList<>();
                }
                position[idx].add(i);
                position[idx].add(j);
            }
        }

        List<String> ans = new ArrayList<>();

        for (String word : words) {

            int firstChar = word.charAt(0) - 'a';
            if (position[firstChar] != null) {
                for (int j = 0; j < position[firstChar].size(); j += 2) {
                    int row = position[firstChar].get(j);
                    int col = position[firstChar].get(j + 1);

                    if (findWord(word, 0, board, row, col)) {
                        ans.add(word);
                        break;
                    }
                }
            }

        }

        return ans;
    }

    private boolean findWord(String word, int index, char[][] board, int row, int col) {
        if (index == word.length()) {
            return true;
        }

        int rl = board.length;
        int cl = board[0].length;
        if (row >= rl || col >= cl || row < 0 || col < 0) {
            return false;
        }

        char c = word.charAt(index);
        if (board[row][col] != c) {
            return false;
        }


        board[row][col] = 'V';
        try {
            if (findWord(word, index + 1, board, row, col + 1)) {
                return true;
            }
            if (findWord(word, index + 1, board, row, col - 1)) {
                return true;
            }
            if (findWord(word, index + 1, board, row - 1, col)) {
                return true;
            }
            if (findWord(word, index + 1, board, row + 1, col)) {
                return true;
            }
        } finally {
            board[row][col] = c;
        }


        return false;
    }
}
