package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/12
 */
class Leet312_maxCoins {

    /**
     * 逆向思维：将气球一个个戳破的过程，反过来，就是一个个添加气球的过程
     */
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val arr = IntArray(n + 2) {
            when (it) {
                0 -> 1
                n + 1 -> 1
                else -> nums[it - 1]
            }
        }

        // dp[i][j] 表示填满开区间(i, j)可获取最大值
        val dp = Array(n + 2) {
            IntArray(n + 2)
        }

        for (i in n - 1 downTo 0) {
            for (j in i + 2..n + 1) {
                for (k in i + 1 until j) {
                    dp[i][j] = dp[i][j].coerceAtLeast(arr[k] * arr[i] * arr[j] + dp[i][k] + dp[k][j])
                }
            }
        }

        return dp[0][n + 1]
    }

    // 暴力解法
//    fun maxCoins(nums: IntArray): Int {
//        val mutableList = nums.toMutableList()
//        return recursive(mutableList)
//    }
//
//    private fun recursive(list: MutableList<Int>): Int {
//        if (list.size == 1) {
//            return list[0]
//        }
//        var ans = 0
//        for (i in 0..list.lastIndex) {
//            val left = if (i - 1 >= 0) list[i - 1] else 1
//            val right = if (i + 1 <= list.lastIndex) list[i + 1] else 1
//
//            val v = list.removeAt(i)
//            ans = ans.coerceAtLeast(v * left * right + recursive(list))
//            list.add(i, v)
//        }
//        return ans
//    }
}