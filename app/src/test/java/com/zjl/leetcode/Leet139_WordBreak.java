package com.zjl.leetcode;

import java.util.List;

/**
 * @author zjl
 * @date 2019-07-11
 */
public class Leet139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;

        return wordBreakInternal(s, 0, wordDict, dp);
    }

    private boolean wordBreakInternal(String s, int fromIndex, List<String> wordDict, Boolean[] dp) {
        if (dp[fromIndex] != null) {
            return dp[fromIndex];
        }

        for (String str : wordDict) {
            if (s.indexOf(str, fromIndex) == fromIndex) {
                if (wordBreakInternal(s, fromIndex + str.length(), wordDict, dp)) {
                    dp[fromIndex] = true;
                    return true;
                }
            }
        }

        dp[fromIndex] = false;
        return false;
    }
}
