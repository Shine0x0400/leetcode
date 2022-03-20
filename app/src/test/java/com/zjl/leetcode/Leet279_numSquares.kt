package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/3
 */
class Leet279_numSquares {
    // DP
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            var min = i
            var j = 1
            while (j * j <= i) {
                min = min.coerceAtMost(dp[i - j * j])
                j++
            }
            dp[i] = 1 + min
        }
        return dp[n]
    }
}