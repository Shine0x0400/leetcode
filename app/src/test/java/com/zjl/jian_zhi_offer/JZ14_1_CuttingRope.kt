package com.zjl.jian_zhi_offer

class JZ14_1_CuttingRope {

//    // 递归，会超时
//    fun cuttingRope(n: Int): Int {
//        if (n == 2 || n == 1) {
//            return 1
//        }
//
//        var result = 0
//        for (i in 1..n - 1) {
//            result = kotlin.math.max(result, i * kotlin.math.max(cuttingRope(n - i), n - i))
//        }
//
//        return result
//    }

    // 动态规划
    fun cuttingRope(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 1
        for (i in 3..n) {
            for (j in 1 until i) {
                dp[i] = kotlin.math.max(dp[i], j * (kotlin.math.max(dp[i - j], i - j)))
            }
        }

        return dp[n]
    }
}