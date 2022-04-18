package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/21
 */
class Leet581_findUnsortedSubarray {

    // 两次不同方向冒泡排序确定边界
    fun findUnsortedSubarray(nums: IntArray): Int {
        // 找子数组的右边界
        var r = 0
        var pre = nums[0]
        for (i in 1..nums.lastIndex) {
            if (nums[i] < pre) {
                // need swap
                r = i
            } else {
                pre = nums[i]
            }
        }

        if (r == 0) {
            return 0
        }

        // 找子数组的左边界
        var l = nums.lastIndex
        var post = nums[nums.lastIndex]
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] > post) {
                l = i
            } else {
                post = nums[i]
            }
        }

        return r - l + 1
    }
}