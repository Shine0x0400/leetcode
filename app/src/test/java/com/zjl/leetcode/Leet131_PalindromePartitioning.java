package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-07-04
 */
public class Leet131_PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }

        // dp[i][j] means if subString(i,j) is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];

//        calculateDp(s, dp);

        // set value dp[j][i]
        calculateDpConcise(s, dp);

        return partitionInternal(s, 0, dp);

    }

    private void calculateDpConcise(String s, boolean[][] dp) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1]);
            }
        }
    }

    private void calculateDp(String s, boolean[][] dp) {
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        // substring with length i
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                dp[j][j + i - 1] = dp[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1);
            }
        }
    }

    // using Recursion
    private List<List<String>> partitionInternal(String s, int fromIndex, boolean[][] dp) {
        List<List<String>> ans = new ArrayList<>();

        if (fromIndex == s.length()) {
            ans.add(new LinkedList<String>());

            return ans;
        }

        for (int i = fromIndex; i < s.length(); i++) {
            if (dp[fromIndex][i]) {
                String substring = s.substring(fromIndex, i + 1);
                for (List<String> list : partitionInternal(s, i + 1, dp)) {
                    list.add(0, substring);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
