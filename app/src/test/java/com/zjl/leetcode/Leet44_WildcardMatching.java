package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-25
 */
public class Leet44_WildcardMatching {

    // http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, star = -1, ss = 0;

        while (si < s.length()) {

            if (pi < p.length()) {
                if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
                    si++;
                    pi++;
                    continue;
                }

                if (p.charAt(pi) == '*') {
                    star = pi++;
                    ss = si;
                    continue;
                }
            }

            if (star >= 0) {
                pi = star + 1;
                si = ++ss;
                continue;
            }

            return false;
        }

        while (pi < p.length()) {
            if (p.charAt(pi) != '*') {
                return false;
            }
            pi++;
        }

        return true;
    }

//    // 动态规划
//    public boolean isMatch(String s, String p) {
//        // 动态规划, dp[i][j]表示isMatch(s.subString(i), p.subString(j))
//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        dp[s.length()][p.length()] = true;
//
//        for (int i = s.length(); i >= 0; i--) {
//            for (int j = p.length(); j >= 0; j--) {
//                if (j == p.length()) {
//                    if (i != s.length()) {
//                        dp[i][j] = false;
//                    }
//                    continue;
//                }
//
//                char c = p.charAt(j);
//                if (c == '?') {
//                    dp[i][j] = (i <= s.length() - 1) && dp[i + 1][j + 1];
//                } else if (c == '*') {
//                    dp[i][j] = dp[i][j + 1] // matches empty
//                            || (i <= s.length() - 1) && dp[i + 1][j]; // matches character
//                } else {
//                    dp[i][j] = (i <= s.length() - 1) && s.charAt(i) == c && dp[i + 1][j + 1];
//                }
//            }
//        }
//
//        return dp[0][0];
//
//    }
}
