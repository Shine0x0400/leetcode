package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-07-11
 */
public class Leet140_WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String>[] dp = new List[s.length() + 1];
        ArrayList<String> strings = new ArrayList<>();
        strings.add("");
        dp[s.length()] = strings;

        return wordBreakInternal(s, 0, wordDict, dp);
    }

    private List<String> wordBreakInternal(String s, int fromIndex, List<String> wordDict, List<String>[] dp) {
        if (dp[fromIndex] != null) {
            return dp[fromIndex];
        }

        ArrayList<String> list = new ArrayList<>();
        for (String word : wordDict) {
            if (s.indexOf(word, fromIndex) == fromIndex) {
                if (fromIndex + word.length() == s.length()) {
                    list.add(word);
                    continue;
                }

                for (String post : wordBreakInternal(s, fromIndex + word.length(), wordDict, dp)) {
                    list.add(word + " " + post);
                }
            }
        }

        dp[fromIndex] = list;
        return list;
    }
}
