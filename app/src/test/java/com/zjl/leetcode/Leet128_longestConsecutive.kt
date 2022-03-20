package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/24
 */
class Leet128_longestConsecutive {

    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var ans = 0
        set.forEach {
            // found a start
            if (!set.contains(it - 1)) {
                var len = 1
                var n = it
                while (set.contains(++n)) {
                    len++
                }
                ans = ans.coerceAtLeast(len)
            }
        }

        return ans
    }
}