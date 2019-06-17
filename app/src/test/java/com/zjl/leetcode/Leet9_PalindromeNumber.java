package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-17
 */
public class Leet9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int s = x;
        while (s != 0) {
            int r = s % 10;
            reverse = reverse * 10 + r;

            s = s / 10;
        }

        return reverse == x;
    }
}
