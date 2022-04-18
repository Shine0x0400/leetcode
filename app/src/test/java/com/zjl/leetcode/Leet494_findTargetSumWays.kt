package com.zjl.leetcode

import java.util.*

/**
 *
 *
 * @author zjl
 * @date  2022/4/19
 */
class Leet494_findTargetSumWays {

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return recursive(nums, 0, target, hashMapOf<String, Int>())
    }

    private fun recursive(nums: IntArray, start: Int, target: Int, cache: HashMap<String, Int>): Int {
        val key = "$start-$target"
        if (cache.containsKey(key)) {
            return cache[key]!!
        }

        if (start == nums.size) {
            return if (target == 0) 1 else 0
        }

        val ans = recursive(nums, start + 1, target - nums[start], cache) +
                recursive(nums, start + 1, target + nums[start], cache)
        cache[key] = ans
        return ans
    }
}