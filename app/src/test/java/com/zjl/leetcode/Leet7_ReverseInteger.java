package com.zjl.leetcode;

/**
 * Easy
 * https://leetcode.com/problems/reverse-integer/
 *
 * @author zjl
 * @date 2019-06-07
 */
public class Leet7_ReverseInteger {
    public int reverse(int x) {
        // 用long存储结果，如果int溢出了，则转型为int就不相等了
        long result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result == (int) result ? (int) result : 0;
    }
}
