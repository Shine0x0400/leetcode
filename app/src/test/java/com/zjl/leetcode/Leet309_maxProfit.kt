package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/7
 */
class Leet309_maxProfit {

    // 看了题解
    fun maxProfit(prices: IntArray): Int {
        var profit1 = -prices[0] // 截止到当天，手上有股票的情况，可获取的最大收益
        var profit2 = 0 // 截止到当天，手上无股票，且处于冷冻期的情况，可获取的最大收益
        var profit3 = 0 // 截止到当天，手上无股票，且也不处于冷冻期的情况，可获取的最大收益

        for (i in 1..prices.lastIndex) {
            // 前一天就有股票了，或者今天才买入(说明前一天无股票，且不处于冷冻期)
            val p1 = kotlin.math.max(profit1, profit3 - prices[i])
            val p2 = prices[i] + profit1
            val p3 = kotlin.math.max(profit2, profit3)

            profit1 = p1
            profit2 = p2
            profit3 = p3
        }

        return kotlin.math.max(profit2, profit3)
    }

    fun maxProfit2(prices: IntArray): Int {
        // dp[i] 表示从第i天开始交易，可以获取的最大利润
        val dp = IntArray(prices.size)
        for (i in prices.lastIndex - 1 downTo 0) {
            // 第i天进行了买入, 第j天卖出
            for (j in i + 1..prices.lastIndex) {
                dp[i] = dp[i].coerceAtLeast(
                    (prices[j] - prices[i]).coerceAtLeast(0)
                            + if (j + 2 <= prices.lastIndex) dp[j + 2] else 0
                )
            }
            // 第i天未买入
            dp[i] = dp[i].coerceAtLeast(dp[i + 1])
        }
        return dp[0]
    }
}