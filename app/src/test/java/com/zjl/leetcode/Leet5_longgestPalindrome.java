package com.zjl.leetcode;

import org.junit.Test;

/**
 * @author zjl
 * @date 2019-06-07
 */
public class Leet5_longgestPalindrome {
    @Test
    public void test() {
        String result = new Leet5_longgestPalindrome().longestPalindrome("cbba");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }

        int end = length - 1;
        int max = 1;
        int maxStart = 0;

        // 回文是奇数的情况，回文以i为中心
        for (int i = 0; i < length; i++) {

            // 如果后面的回文长度不会超过max，提前退出
            if (((end - i) << 1) + 1 <= max) {
                break;
            }

            int cnt = 1;
            for (int j = i - 1, k = i + 1; j >= 0 && k < length; j--, k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    cnt += 2;
                    if (cnt > max) {
                        max = cnt;
                        maxStart = j;
                    }
                } else {
                    break;
                }
            }
        }

        // 回文是偶数的情况，回文以i和i+1为中心
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }

            // 如果后面的回文长度不会超过max，提前退出
            if (((end - i) << 1) <= max) {
                break;
            }

            int cnt = 0;
            for (int j = i, k = i + 1; j >= 0 && k < length; j--, k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    cnt += 2;
                    if (cnt > max) {
                        max = cnt;
                        maxStart = j;
                    }
                } else {
                    break;
                }
            }
        }

        return s.substring(maxStart, maxStart + max);
    }
}
