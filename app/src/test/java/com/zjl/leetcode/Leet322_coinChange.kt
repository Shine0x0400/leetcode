package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/12
 */
class Leet322_coinChange {
    // dynamic programing
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { -1 }
        dp[0] = 0
        for (i in 1..amount) {
            coins.forEach {
                if (i - it >= 0 && dp[i - it] != -1) {
                    val v = 1 + dp[i - it]
                    dp[i] = if (dp[i] == -1) v else dp[i].coerceAtMost(v)
                }
            }
        }
        return dp[amount]
    }

    /**
     * backtrace
     */
    var minCount = -1
    fun coinChange1(coins: IntArray, amount: Int): Int {
        backtrace(coins, amount, 0)
        return minCount
    }

    private fun backtrace(coins: IntArray, amount: Int, count: Int) {
        if (amount == 0) {
            minCount = if (minCount == -1) {
                count
            } else {
                minCount.coerceAtMost(count)
            }
            return
        }
        if (amount < 0) {
            return
        }
        for (i in 0..coins.lastIndex) {
            backtrace(coins, amount - coins[i], count + 1)
        }
    }
}