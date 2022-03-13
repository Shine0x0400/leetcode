package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author zjl
 * @date  2022/3/13
 */
class JZ63_maxProfit {
    fun maxProfit(prices: IntArray): Int {
        var buy = 0
        var max = 0

        prices.forEachIndexed { i, v ->
            if (i == 0) {
                return@forEachIndexed
            }

            if (v > prices[buy]) {
                max = max.coerceAtLeast(v - prices[buy])
            } else {
                buy = i
            }
        }

        return max
    }
}