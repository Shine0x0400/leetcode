package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet22_GenerateParentheses {
    private List<String> list;

    // Backtracking
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();

        generateParenthesisInternal("", n, n);

        return list;
    }

    private void generateParenthesisInternal(String combination, int left, int right) {
        if (right == 0) {
            list.add(combination);
            return;
        }

        if (right > left) {
            generateParenthesisInternal(combination + ")", left, right - 1);
        }

        if (left > 0) {
            generateParenthesisInternal(combination + "(", left - 1, right);
        }
    }

//    // using Closure Number
//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        if (n <= 0) {
//            list.add("");
//            return list;
//        }
//
//        // "(left)right", the first parenthesis pair could contains [0, n-1] parenthesis pairs.
//        for (int c = 0; c < n; c++) {
//
//            for (String left : generateParenthesis(c)) {
//                for (String right : generateParenthesis(n - c - 1)) {
//                    list.add("(" + left + ")" + right);
//                }
//            }
//        }
//
//        return list;
//    }
}
