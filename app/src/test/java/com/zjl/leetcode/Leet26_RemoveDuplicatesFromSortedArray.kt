package com.zjl.leetcode

/**
 *
 *
 * @author dylannzhang
 * @date 2021/8/8
 */
class Leet26_RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        for (n in nums) {
            if (n != nums[i]) {
                nums[++i] = n
            }
        }

        return if (nums.size == 0) 0 else i + 1
    }
}