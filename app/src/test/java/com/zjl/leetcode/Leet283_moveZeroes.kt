package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/4/4
 */
class Leet283_moveZeroes {

    fun moveZeroes(nums: IntArray): Unit {
        var fast = 0
        var slow = 0
        while (fast < nums.size) {
            if (nums[fast] != 0) {
                if (fast != slow) {
                    nums[slow] = nums[fast]
                    nums[fast] = 0
                }
                slow++
            }
            fast++
        }
    }
}