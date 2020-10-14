package com.zjl.leetcode;

/**
 * "aaaaaaaaaaaaab"
 * "a*a*a*a*a*a*a*a*a*a*c"
 * test case: Time Limit Exceeded
 *
 * @author zjl
 * @date 2019-06-17
 */
public class Leet10_RegExpMatch {


//    // use recursion -- my recursion
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//
//        if ("".equals(s)) {
//            for (int i = 0; i < p.length(); i++) {
//                if (p.charAt(i) != '*' && (i == p.length() - 1 || p.charAt(i + 1) != '*')) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//
//        char c = s.charAt(0);
//        boolean match = false;
//
//        // this isn't really for looping, just find the first char match s.charAt(0), then RETURN recursion result.
//        for (int i = 0; i < p.length(); i++) {
//            if (p.charAt(i) == '*') {
//                continue;
//            } else if (p.charAt(i) == c || p.charAt(i) == '.') {
//                // consume s.charAt(0), NOT repeat p.charAt(i)
//                match = isMatch(s.substring(1), p.substring(i + 1));
//                if (match || i == p.length() - 1 || p.charAt(i + 1) != '*') {
//                    return match;
//                }
//
//                // consume s.charAt(0), repeat p.charAt(i)
//                match = isMatch(s.substring(1), p.substring(i));
//                if (match) {
//                    return true;
//                }
//
//                // NOT consume s.charAt(0), NOT repeat p.charAt(i)
//                match = isMatch(s, p.substring(i + 1));
//                if (match) {
//                    return true;
//                }
//
//                return false;
//            } else {
//                if (i == p.length() - 1 || p.charAt(i + 1) != '*') {
//                    return false;
//                }
//            }
//        }
//
//        return false;
//
//    }


//    // Official Solution
//    public boolean isMatch(String text, String pattern) {
//        int i = 0;
//        for (; i < pattern.length(); i++) {
//            if (pattern.charAt(i) != '*') {
//                break;
//            }
//        }
//        pattern = pattern.substring(i);
//
//        if (pattern.isEmpty()) return text.isEmpty();
//
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

    // Dynamic Programing
    public boolean isMatch(String s, String p) {
        // dp(i, j)表示 isMatch(s.subString(i), p.subString(j))
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {

                boolean firstMatch = i < s.length()
                        && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] // * means zero repetition
                            || (firstMatch && dp[i + 1][j]); // * means once or more repetition
                } else { // p.charAt(j) can not be ignored
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
