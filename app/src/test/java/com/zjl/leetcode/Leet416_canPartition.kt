package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/17
 */
class Leet416_canPartition {
    // 题解是用的DP
    fun canPartition(nums: IntArray): Boolean {
        if (nums.size < 2) {
            return false
        }

        val sum = nums.sum()
        if (sum % 2 != 0) {
            return false
        }

        val half = sum shr 1
        // dp[i][j] 表示[0, i]区间内的数字，是否存在集合，其和为j
        val dp = Array(nums.size) {
            BooleanArray(half + 1)
        }
        for (i in 0..nums.lastIndex) {
            dp[i][0] = true
        }
        if (nums[0] <= half) {
            dp[0][nums[0]] = true
        }

        for (i in 1..nums.lastIndex) {
            for (j in 1..half) {
                dp[i][j] = if (nums[i] > j) {
                    dp[i - 1][j]
                } else {
                    dp[i - 1][j] || dp[i - 1][j - nums[i]]
                }
            }
        }

        return dp[nums.lastIndex][half]
    }


//    var ans = false
//    val tracked = hashSetOf<String>()
//    fun canPartition(nums: IntArray): Boolean {
//        ans = false
//        backtracking(nums, 0, 0, 0)
//        return ans
//    }
//
//    private fun backtracking(nums: IntArray, i: Int, groupA: Int, groupB: Int) {
//        if (ans) {
//            return
//        }
//
//        // 记忆已访问路劲
//        val key = "$groupA-$groupB-$i"
//        if (tracked.contains(key)) {
//            return
//        }
//        tracked.add(key)
//
//        if (i == nums.size) {
//            if (groupA == groupB) {
//                ans = true
//            }
//            return
//        }
//        backtracking(nums, i + 1, groupA + nums[i], groupB)
//        backtracking(nums, i + 1, groupA, groupB + nums[i])
//    }
}