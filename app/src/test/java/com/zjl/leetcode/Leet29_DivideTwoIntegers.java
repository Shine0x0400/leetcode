package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean positive = (dividend ^ divisor) >= 0;

        long dvd = Math.abs(((long) dividend));
        long dvs = Math.abs(((long) divisor));
        long quotient = 0;

        while (dvd >= dvs) {
            long tmp = dvs;
            long times = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                times <<= 1;
            }

            dvd -= tmp;
            quotient += times;
        }

        return (int) (positive ? quotient : -quotient);
    }
}
