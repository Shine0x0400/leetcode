package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/6
 */
class Leet300_lengthOfLIS {

    fun lengthOfLIS(nums: IntArray): Int {
        // dp[i]表示，长度为i的递增序列的最小末尾数, dp数组是个单调递增数组，证明见题解
        val dp = IntArray(nums.size + 1)
        dp[1] = nums[0]
        var len = 1
        nums.forEach {
            if (it > dp[len]) {
                dp[++len] = it
            } else if (it < dp[len]) {
                var l = 1
                var r = len
                var pos = 0
                while (l <= r) {
                    val m = (l + r) shr 1
                    if (dp[m] < it) {
                        l = m + 1
                    } else {
                        pos = m
                        r = m - 1
                    }
                }
                dp[pos] = it
            }
        }
        return len
    }
}