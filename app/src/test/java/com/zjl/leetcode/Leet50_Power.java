package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet50_Power {

//    // using Recursion
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//
//        double r = 1;
//        if (n < 0) {
//
//            if ((n & 1) == 1) {
//                r = 1 / x;
//            }
//
//            n = -(n / 2);
//            x = (1 / x) * (1 / x);
//
//        }
//
//        return n % 2 == 0 ? r * myPow(x * x, n / 2) : r * x * myPow(x * x, n / 2);
//    }

//    // NOT using Recursion
//    // https://zh.wikipedia.org/wiki/%E5%86%AA
//    public double myPow(double x, int n) {
//
//        double y = 1;
//        double f = x;
//        int k = n;
//
//        if (n < 0) {
//            if ((n & 1) == 1) {
//                y = 1 / x;
//            }
//
//            k = -(n / 2);
//            f = (1 / x) * (1 / x);
//        }
//
//        while (k > 0) {
//            if (k % 2 == 1) {
//                y *= f;
//            }
//
//            k >>= 1;
//            f *= f;
//        }
//
//        return y;
//    }

    // 重操旧业
    public double myPow(double x, int n) {
        double result = 1;
        int k = Math.abs(n);
        double y = x;

        // 负数取反是先所有位取反(包括符号为)，再+1
        // java中，Integer.MIN_VALUE取绝对值等于自身
        if (k == Integer.MIN_VALUE) {
            k = Integer.MAX_VALUE;
            result = x;
        }

        while (k > 0) {
            if (k % 2 == 1) {
                result *= y;
            }

            k >>= 1;
            y *= y;
        }

        if (n > 0) {
            return result;
        }

        return 1 / result;
    }

//    /**
//     * Time Limit Exceeded
//     * Last executed input:
//     * 0.00001
//     * 2147483647
//     */
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//
//        int remain = Math.abs(n);
//
//        double result = 1;
//
//        while (remain > 0) {
//            int pow = 2;
//            double tmp = x;
//            while (pow <= remain) {
//                tmp *= tmp;
//                pow <<= 1;
//            }
//
//            result *= tmp;
//
//            pow >>= 1;
//            remain -= pow;
//        }
//
//        if (n > 0) {
//            return result;
//        }
//
//        return 1 / result;
//    }

//    /**
//     * x^n
//     * Time Limit Exceeded:
//     * 0.00001
//     * 2147483647
//     */
//    public double myPow(double x, int n) {
//        // not support in math
//        if (x == 0 && n < 0) {
//            return -1;
//        }
//
//        if (n == 0) {
//            return 1;
//        }
//
//        if (x == 0) {
//            return 0;
//        }
//
//        if (x == 1) {
//            return 1;
//        }
//
//        if (x == -1) {
//            // 奇数
//            if ((n & 1) == 1) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }
//
//        boolean positive = n > 0;
//        long nabs = Math.abs(((long) n));
//
//        double r = 1;
//        for (int i = 0; i < nabs; i++) {
//            r *= x;
//        }
//
//        return positive ? r : 1 / r;
//    }
}
