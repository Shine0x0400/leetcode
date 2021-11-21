package com.zjl.jian_zhi_offer

import java.math.BigInteger

class JZ14_2_CuttingRope {

    // 动态规划，使用BigInteger解决溢出问题
    fun cuttingRope(n: Int): Int {
        val dp = Array<BigInteger>(n + 1) { BigInteger.ZERO }
        dp[1] = BigInteger.ONE
        dp[2] = BigInteger.ONE
        for (i in 3..n) {
            for (j in 1 until i) {
                dp[i] = dp[i].max(
                    BigInteger.valueOf(j.toLong())
                        .multiply(dp[i - j].max(BigInteger.valueOf(i.toLong() - j)))
                )
            }
        }

        return (dp[n].mod(BigInteger.valueOf(1000000007))).toInt()
    }
}