package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/20
 */
class Leet121_maxProfit {

    fun maxProfit(prices: IntArray): Int {
        var buy = prices.first()
        var max = 0
        prices.forEach {
            if (it > buy) {
                max = max.coerceAtLeast(it - buy)
            } else {
                buy = it
            }
        }
        return max
    }
}