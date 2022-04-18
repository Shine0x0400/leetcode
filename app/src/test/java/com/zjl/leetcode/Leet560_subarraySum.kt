package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/20
 */
class Leet560_subarraySum {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var ans = 0
        var sum = 0
        val prefixSum = hashMapOf<Int, Int>()
        prefixSum[0] = 1
        nums.forEach {
            sum += it
            ans += prefixSum.getOrDefault(sum - k, 0)
            prefixSum[sum] = prefixSum.getOrDefault(sum, 0) + 1
        }
        return ans
    }
}